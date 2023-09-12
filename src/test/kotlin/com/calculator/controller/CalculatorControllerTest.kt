package com.calculator.controller

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest
class CalculatorControllerTest(@Autowired val mockMvc: MockMvc) {

    @Test
    fun `Two values can be added`() {
        val paramsJson = """{
            | "operand1": "1",
            | "operand2": "2"
            |}""".trimMargin()
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

        val paramsJson = """{
            | "operand1": "Foo",
            | "operand2": "2"
            |}""".trimMargin()
        mockMvc.perform(
            post("/calculator/add")
                .content(paramsJson)
                .contentType(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isBadRequest)
    }

    @Test
    fun `Bad request when second operand is not a number`() {

        val paramsJson = """{
            | "operand1": "1",
            | "operand2": "Bar"
            |}""".trimMargin()
        mockMvc.perform(
            post("/calculator/add")
                .content(paramsJson)
                .contentType(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isBadRequest)
    }
}