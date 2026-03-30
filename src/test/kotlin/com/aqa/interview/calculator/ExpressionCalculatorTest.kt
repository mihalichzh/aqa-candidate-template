package com.aqa.interview.calculator

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
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
                ),
                ValidEvaluationCase(
                    expression = "-2 - 2",
                    result = "-4",
                    description = "subtract of negative ints"
                ),
                ValidEvaluationCase(
                    expression = "23 * 0",
                    result = "0",
                    description = "multiply ints by zero"
                ),
                ValidEvaluationCase(
                    expression = "1.2 + 2.3",
                    result = "3.5",
                    description = "sum of floats"
                ),
                ValidEvaluationCase(
                    expression = "1.2 + 2.3",
                    result = "3.5",
                    description = "sum of floats"
                ),
                ValidEvaluationCase(
                    expression = "0 / 2",
                    result = "0",
                    description = "divide 0 by positive int"
                ),
                ValidEvaluationCase(
                    expression = "5.0 / 2",
                    result = "2.5",
                    description = "divide 0 by positive int"
                ),
                ValidEvaluationCase(
                    expression = "+2 + 3",
                    result = "5",
                    description = "use explicit sign (+)"
                ),
                ValidEvaluationCase(
                    expression = "5",
                    result = "5",
                    description = "pass single num"
                ),
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
