package com.codefox.moexservice.dto

import javax.validation.constraints.NotNull


class TickersDto(
    @NotNull(message = "Name cannot be null")
    val tickers: List<String>,
)