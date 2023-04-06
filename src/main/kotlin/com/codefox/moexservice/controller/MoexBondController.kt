package com.codefox.moexservice.controller

import com.codefox.moexservice.dto.StocksDto
import com.codefox.moexservice.dto.TickersDto
import com.codefox.moexservice.service.BondService
import org.springframework.web.bind.annotation.*


@RequestMapping("/bonds")
@RestController
class MoexBondController(private val bondService: BondService) {

    @PostMapping("/getBondsByTickers")
    fun getBondsFromMoex(@RequestBody tickersDto: TickersDto): StocksDto {
        return bondService.getBondsFromMoex(tickersDto)
    }

    @GetMapping("/getAllBonds")
    fun getAllBonds(): StocksDto? = bondService.getAllBonds()

    @GetMapping("/getCorporateBonds")
    fun getAllCorporateBonds(): StocksDto? = bondService.getAllCorporateBonds()

    @GetMapping("/getGovBonds")
    fun getAllGovBonds(): StocksDto? = bondService.getAllGovBonds()
}