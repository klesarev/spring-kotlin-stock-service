package com.codefox.moexservice.parser

import com.codefox.moexservice.dto.BondDto

interface Parser {
    fun parse(ratesAsString: String): List<BondDto>?
}