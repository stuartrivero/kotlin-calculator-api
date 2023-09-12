package com.calculator.controller

import com.calculator.services.CalculatorService
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import java.math.BigDecimal

@WebMvcTest
class CalculatorControllerTest(@Autowired val mockMvc: MockMvc) {

    @MockkBean
    lateinit var calculatorService: CalculatorService

    @Test
    fun `Two values can be added`() {
        val paramsJson = calculationBody("1", "2")

        every { calculatorService.add(BigDecimal("1"), BigDecimal("2")) } returns BigDecimal("3")

        mockMvc.perform(
            post("/calculator/add")
                .content(paramsJson)
                .contentType(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isOk())
            .andExpect(content().string("1 + 2 = 3"))
    }

    @Test
    fun `Bad request when first operand is not a number`() {

        val paramsJson = calculationBody("Foo", "2")
        mockMvc.perform(
            post("/calculator/add")
                .content(paramsJson)
                .contentType(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isBadRequest)
    }

    @Test
    fun `Bad request when second operand is not a number`() {

        val paramsJson = calculationBody("1", "Bar")
        mockMvc.perform(
            post("/calculator/add")
                .content(paramsJson)
                .contentType(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isBadRequest)
    }

    private fun calculationBody(operand1: String, operand2: String) = """{
                | "operand1": "$operand1",
                | "operand2": "$operand2"
                |}""".trimMargin()
}