package com.codefox.moexservice.model

class Stock (
    var ticker: String? = null,
    var figi: String? = null,
    var name: String? = null,
    var type: String? = null,
    var currency: Currency? = null,
    var source: String? = null
)