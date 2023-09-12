package com.calculator.services

import org.junit.jupiter.api.Test
import java.math.BigDecimal
import org.assertj.core.api.Assertions.*

class CalculatorServiceTest {

    @Test
    fun `Two Positive numbers can be added`() {
        val calculatorService = CalculatorService()
        assertThat(calculatorService.add(BigDecimal("1.01"), BigDecimal("2.03"))).isEqualTo(BigDecimal("3.04"))
    }

    @Test
    fun `Two numbers with different signs can be added`() {
        val calculatorService = CalculatorService()
        assertThat(calculatorService.add(BigDecimal("1.01"), BigDecimal("-2.03"))).isEqualTo(BigDecimal("-1.02"))
    }

    @Test
    fun `Two Negative numbers can be added`() {
        val calculatorService = CalculatorService()
        assertThat(calculatorService.add(BigDecimal("-1.01"), BigDecimal("-2.03"))).isEqualTo(BigDecimal("-3.04"))
    }
}