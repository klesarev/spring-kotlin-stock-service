package com.codefox.moexservice.moexclient

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping

@Component
@FeignClient(name = "govbonds", url = "\${moex.bonds.government.url}")
interface GovBondClient {
    @GetMapping
    fun getGovBonds(): String
}