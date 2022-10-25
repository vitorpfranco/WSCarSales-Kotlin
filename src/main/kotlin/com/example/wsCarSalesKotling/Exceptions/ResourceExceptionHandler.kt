package com.example.wsCarSalesKotling.Exceptions

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import javax.servlet.http.HttpServletRequest


@ControllerAdvice
class ResourceExceptionHandler {


    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun validationError(
        ex: MethodArgumentNotValidException,
        request: HttpServletRequest
    ): ResponseEntity<StandardError?>? {
        val errors = ValidationError(
            System.currentTimeMillis(),
            HttpStatus.BAD_REQUEST.value(),
            "Field validation error",
            "Mandatory or invalid fields:",
            request.requestURI
        )
        for (x in ex.bindingResult.fieldErrors) {
            errors.add(x.field, x.defaultMessage)
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors)
    }

}