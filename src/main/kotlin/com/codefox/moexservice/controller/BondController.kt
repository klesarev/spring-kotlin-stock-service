package com.codefox.moexservice.controller

import com.codefox.moexservice.dto.StocksDto
import com.codefox.moexservice.dto.TickersDto
import com.codefox.moexservice.service.BondService
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RequestMapping("/bonds")
@RestController
class BondController(private val bondService: BondService) {

    @PostMapping("/getBondsByTickers")
    fun getBondsByTickers(@Valid @RequestBody tickersDto: TickersDto): StocksDto {
        return bondService.getBondsByTickers(tickersDto)
    }

    @GetMapping("/getAllBonds")
    fun getAllBonds(): StocksDto? = bondService.getAllBonds()

    @GetMapping("/getCorporateBonds")
    fun getAllCorporateBonds(): StocksDto? = bondService.getAllCorporateBonds()

    @GetMapping("/getGovBonds")
    fun getAllGovBonds(): StocksDto? = bondService.getAllGovBonds()

}