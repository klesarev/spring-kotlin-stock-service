package com.codefox.moexservice.parser

import com.codefox.moexservice.dto.BondDto
import com.codefox.moexservice.dto.StocksDto
import com.codefox.moexservice.model.Currency
import com.codefox.moexservice.model.Stock
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean

@SpringBootTest
internal class MoexBondXmlParserTest {

    companion object {
        val testBonds = listOf<BondDto>(
            BondDto("RU000A0JS6M0","РосбанкБО5"),
            BondDto("RU000A0JU773","ВТБ БО-43")
        )
    }

    @Autowired
    lateinit var testParser: MoexBondXmlParser

    @Test
    fun parseBondsTest() {

    }
}