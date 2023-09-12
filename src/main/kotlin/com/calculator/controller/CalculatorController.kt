package com.calculator.controller

import com.calculator.services.CalculatorService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal


@RestController
@RequestMapping("/calculator")
class CalculatorController(private val calculatorService: CalculatorService) {


    @PostMapping
    @RequestMapping("/add")
    fun add(@RequestBody calculation: AddCalculation): ResponseEntity<String> {
        val result = calculatorService.add(calculation.operand1, calculation.operand2)
        return ResponseEntity("${calculation.operand1} + ${calculation.operand2} = $result", HttpStatus.OK)
    }

    data class AddCalculation(val operand1: BigDecimal, val operand2: BigDecimal)
}