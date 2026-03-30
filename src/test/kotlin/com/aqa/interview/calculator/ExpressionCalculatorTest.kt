package com.aqa.interview.calculator

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.Test
import kotlin.test.assertEquals

class ExpressionCalculatorTest {

    private val calculator = calculator()

    companion object {
        @JvmStatic
        fun validEvaluationCases(): List<ValidEvaluationCase> {
            return listOf(
                ValidEvaluationCase(
                    expression = "1 + 2",
                    result = "3",
                    description = "sum of positive ints"
                )
            )
        }
    }

    @MethodSource("validEvaluationCases")
    @ParameterizedTest
    fun `addition of two integers`(case: ValidEvaluationCase) {
        assertEquals(case.result, calculator.evaluate(case.expression))
    }

    data class ValidEvaluationCase(
        val expression: String,
        val result: String,
        val description: String,
    )
}
