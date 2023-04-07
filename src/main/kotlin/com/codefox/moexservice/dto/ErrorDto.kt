package com.codefox.moexservice.dto

import com.codefox.moexservice.exception.ErrorCodes

class ErrorDto(
    val localizedMessage: String,
    val errorMessage: String,
    val code: Int
)