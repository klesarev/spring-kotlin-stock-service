package com.codefox.moexservice.dto

import com.codefox.moexservice.model.Stock


data class StocksDto (
    var stocks: List<Stock>? = null,
    var error: ErrorDto = ErrorDto()
)