package com.codefox.moexservice.service

import com.codefox.moexservice.dto.StocksDto
import com.codefox.moexservice.dto.TickersDto
import com.codefox.moexservice.model.Currency
import com.codefox.moexservice.model.Stock
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class BondServiceTest {

    companion object {
        val testTickers = TickersDto(
            listOf("RU000A102796", "SU24021RMFS6") // ТинькоффИ1 // ОФЗ 24021
        )
        val testStocks = StocksDto(
            stocks = listOf(
                Stock("RU000A102796", "RU000A102796", "ТинькоффИ1", "Bond", Currency.RUB, "MOEX"),
                Stock("SU24021RMFS6", "SU24021RMFS6", "ОФЗ 24021", "Bond", Currency.RUB, "MOEX")
            )
        )
    }

    @Autowired
    lateinit var bondService: BondService

    @Test
    fun getBondsByTickers() {

        val resultStocks = bondService.getBondsByTickers(testTickers)

        resultStocks.stocks?.mapIndexed { index, stock ->
            assertEquals(stock.ticker, testStocks.stocks!![index].ticker)
            assertEquals(stock.currency, testStocks.stocks!![index].currency)
            assertEquals(stock.name, testStocks.stocks!![index].name)
        }
    }

    // Add null tickers body test
    // Add incorrect format body tickers test (Int, Boolean)
    // Add null listOf tickers test
    // Add MockTest
}