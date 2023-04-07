package com.codefox.moexservice.dto

import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive


class TickersDto(
    @NotNull(message = "Name cannot be null")
    val tickers: List<String>,
)