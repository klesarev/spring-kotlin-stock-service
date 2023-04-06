package com.codefox.moexservice.service

import com.codefox.moexservice.dto.BondDto
import com.codefox.moexservice.dto.StocksDto
import com.codefox.moexservice.dto.TickersDto
import com.codefox.moexservice.model.Currency
import com.codefox.moexservice.model.Stock
import com.codefox.moexservice.moexclient.CorporateBondClient
import com.codefox.moexservice.moexclient.GovBondClient
import com.codefox.moexservice.parser.Parser
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class BondService()  {

    @Autowired
    lateinit var corporateBondClient: CorporateBondClient

    @Autowired
    lateinit var govBondClient: GovBondClient

    @Autowired
    lateinit var parser: Parser

    fun getBondsFromMoex(tickersDto: TickersDto): StocksDto {

        val allBonds = mutableListOf<BondDto>()
        allBonds.addAll(getCorporateBonds() as List)
        allBonds.addAll(getGovBonds() as List)

        val resultBonds = when {
            tickersDto.tickers.isEmpty() -> allBonds
            tickersDto.tickers.contains("string") -> allBonds
            else -> allBonds.filter { b-> tickersDto.tickers.contains(b.ticker) }
        }

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

    private fun getCorporateBonds(): List<BondDto>? {
        val xmlFromMoex: String = corporateBondClient.getBondsFromMoex()
        return parser.parse(xmlFromMoex)
    }

    private fun getGovBonds(): List<BondDto>? {
        val xmlFromMoex: String = govBondClient.getGovBonds()
        return parser.parse(xmlFromMoex)
    }

    fun getAllBonds(): StocksDto {
        val allBonds = mutableListOf<BondDto>()
        allBonds.addAll(getCorporateBonds() as List)
        allBonds.addAll(getGovBonds() as List)

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

        val stocks = getCorporateBonds()?.map { stock ->
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
        val stocks = getGovBonds()?.map { stock ->
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