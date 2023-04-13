package com.codefox.moexservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class StockApplication

fun main(args: Array<String>) {
	runApplication<StockApplication>(*args)
}
