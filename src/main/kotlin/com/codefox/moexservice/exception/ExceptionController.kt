package com.codefox.moexservice.exception

import com.codefox.moexservice.dto.ErrorDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler


@ControllerAdvice
class ExceptionController : ResponseEntityExceptionHandler() {

    @ExceptionHandler(XMLParsingException::class)
    fun handleNotFound(e: Exception): ResponseEntity<ErrorDto> {
        return ResponseEntity<ErrorDto>(ErrorDto(ErrorCodes.XMLError.errorMessage, 1), HttpStatus.ACCEPTED)
    }

}