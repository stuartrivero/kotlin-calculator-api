package com.calculator.services

import java.math.BigDecimal

class CalculatorService {
    fun add(first: BigDecimal, second: BigDecimal): BigDecimal {
        return first.add(second)
    }
}