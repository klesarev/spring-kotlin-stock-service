package com.codefox.moexservice.parser

import com.codefox.moexservice.dto.BondDto
import com.codefox.moexservice.exception.XMLParsingException
import org.springframework.stereotype.Component
import java.io.StringReader
import javax.xml.XMLConstants
import javax.xml.parsers.DocumentBuilderFactory

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

@Component
class MoexBondXmlParser : Parser {
    override fun parse(ratesAsString: String): List<BondDto>? {

        val bonds = ArrayList<BondDto>()

        val dbf = DocumentBuilderFactory.newInstance()
        dbf.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "")
        dbf.setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "")

        try {
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true)
            val db = dbf.newDocumentBuilder()

            StringReader(ratesAsString).use { reader ->
                val doc: Document = db.parse(InputSource(reader))
                doc.documentElement.normalize()

                val list: NodeList = doc.getElementsByTagName("row")

                for (rowIdx in 0 until list.length) {
                    val node = list.item(rowIdx)
                    if (node.nodeType == Node.ELEMENT_NODE) {
                        val element: Element = node as Element
                        val ticker: String = element.getAttribute("SECID")
                        val name: String = element.getAttribute("SHORTNAME")
                        if (ticker.isNotEmpty() && name.isNotEmpty()) {
                            bonds.add(BondDto(ticker, name))
                        }
                    }
                }
            }

        } catch (e: Exception) {
            e.printStackTrace()
            throw XMLParsingException(e)
        }
        return bonds
    }

}