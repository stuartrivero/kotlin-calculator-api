package com.calculator.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal


@RestController
@RequestMapping("/calculator")
class CalculatorController {

    @PostMapping
    @RequestMapping("/add")
    fun add(@RequestBody calculation: AddCalculation): ResponseEntity<String> {
        return ResponseEntity("1 + 2 = 3", HttpStatus.OK)
    }

    data class AddCalculation(val operand1: BigDecimal, val operand2: BigDecimal)
}