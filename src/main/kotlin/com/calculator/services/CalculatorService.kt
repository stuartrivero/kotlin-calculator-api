package com.calculator.services

import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class CalculatorService {
    fun add(first: BigDecimal, second: BigDecimal): BigDecimal {
        return first.add(second)
    }
}