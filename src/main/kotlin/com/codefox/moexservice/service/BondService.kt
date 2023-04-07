package com.codefox.moexservice.service

import com.codefox.moexservice.dto.BondDto
import com.codefox.moexservice.dto.StocksDto
import com.codefox.moexservice.dto.TickersDto
import com.codefox.moexservice.model.Currency
import com.codefox.moexservice.model.Stock
import com.codefox.moexservice.client.CorporateBondClient
import com.codefox.moexservice.client.GovBondClient
import com.codefox.moexservice.parser.Parser
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class BondService(
    private val corporateBondClient: CorporateBondClient,
    private val govBondClient: GovBondClient,
    private val parser: Parser
)  {

    fun getBondsFromMoex(tickersDto: TickersDto): StocksDto {

        val allBonds = mutableListOf<BondDto>()
        allBonds.addAll(parseCorporateBonds() as List)
        allBonds.addAll(parseGovBonds() as List)

        val resultBonds = allBonds.filter { b-> tickersDto.tickers.contains(b.ticker) }

        // вынести в mapper
        val stocks = resultBonds.map { stock ->
            Stock(
                ticker = stock.ticker,
                name = stock.name,
                figi = stock.ticker,
                type = "Bond",
                currency = Currency.RUB,
                source = "MOEX"
            )
        }
        return StocksDto(stocks)
    }

    private fun parseCorporateBonds(): List<BondDto>? {
        val xmlFromMoex: String = corporateBondClient.getBondsFromMoex()
        return parser.parse(xmlFromMoex)
    }

    private fun parseGovBonds(): List<BondDto>? {
        val xmlFromMoex: String = govBondClient.getGovBonds()
        return parser.parse(xmlFromMoex)
    }

    fun getAllBonds(): StocksDto {
        val allBonds = mutableListOf<BondDto>()
        allBonds.addAll(parseCorporateBonds() as List)
        allBonds.addAll(parseGovBonds() as List)

        // вынести в mapper
        val stocks = allBonds.map { stock ->
            Stock(
                ticker = stock.ticker,
                name = stock.name,
                figi = stock.ticker,
                type = "Bond",
                currency = Currency.RUB,
                source = "MOEX"
            )
        }

        return StocksDto(stocks)
    }

    fun getAllCorporateBonds(): StocksDto {

        // вынести в mapper
        val stocks = parseCorporateBonds()?.map { stock ->
            Stock(
                ticker = stock.ticker,
                name = stock.name,
                figi = stock.ticker,
                type = "Bond",
                currency = Currency.RUB,
                source = "MOEX"
            )
        }

        return StocksDto(stocks)
    }

    fun getAllGovBonds(): StocksDto {

        // вынести в mapper
        val stocks = parseGovBonds()?.map { stock ->
            Stock(
                ticker = stock.ticker,
                name = stock.name,
                figi = stock.ticker,
                type = "Bond",
                currency = Currency.RUB,
                source = "MOEX"
            )
        }

        return StocksDto(stocks)
    }
}