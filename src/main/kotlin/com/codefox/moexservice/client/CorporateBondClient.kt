package com.codefox.moexservice.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(
    name = "corporatebonds",
    url = "\${moex.bonds.corporate.url}",
    configuration = [ClientConfig::class] // arrayOf KClass<*>
)
interface CorporateBondClient {
    @GetMapping
    fun getBondsFromMoex(): String
}