package com.codefox.moexservice.controller

import com.codefox.moexservice.dto.ErrorDto
import com.codefox.moexservice.dto.StocksDto
import com.codefox.moexservice.dto.TickersDto
import com.codefox.moexservice.service.BondService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RequestMapping("/bonds")
@RestController
class MoexBondController(private val bondService: BondService) {

    @GetMapping("/alive")
    fun getStatus(): ErrorDto = ErrorDto("no error", 0)

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