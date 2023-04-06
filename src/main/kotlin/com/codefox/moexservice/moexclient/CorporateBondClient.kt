package com.codefox.moexservice.moexclient

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(name = "corporatebonds", url = "\${moex.bonds.corporate.url}")
interface CorporateBondClient {
    @GetMapping
    fun getBondsFromMoex(): String
}