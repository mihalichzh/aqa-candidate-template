package com.aqa.interview.calculator

import org.junit.jupiter.api.assertThrows
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
                    expression = "-2 + 3",
                    result = "1",
                    description = "use explicit sign (-)"
                ),
                ValidEvaluationCase(
                    expression = "5",
                    result = "5",
                    description = "pass single num"
                ),
                ValidEvaluationCase(
                    expression = "2 + 4 * 5",
                    result = "22",
                    description = "multiplication has higher priority than sum"
                ),
                ValidEvaluationCase(
                    expression = "(2 + 4) * 5",
                    result = "30",
                    description = "operation with parenthesis"
                ),
                ValidEvaluationCase(
                    expression = "(2 + (4 - 2)) * 5",
                    result = "20",
                    description = "nested operation with parenthesis"
                ),
                ValidEvaluationCase(
                    expression = "--99",
                    result = "99",
                    description = "double negative number"
                ),
                ValidEvaluationCase(
                    expression = "9999999999 + 1",
                    result = (9999999999 + 1).toString(),
                    description = "user reported bug '9999999999 + 1'",
                ),
                ValidEvaluationCase(
                    expression = "9999999998 + 1",
                    result = (9999999998 + 1).toString(),
                    description = "user reported bug '9999999998 + 1'",
                ),
                ValidEvaluationCase(
                    expression = "9999999999 + 2",
                    result = (9999999999 + 2).toString(),
                    description = "user reported bug '9999999999 + 2'",
                ),
                ValidEvaluationCase(
                    expression = "8888888888 + 2314",
                    result = (8888888888 + 2314).toString(),
                    description = "user reported bug '8888888888 + 2314'",
                ),
                ValidEvaluationCase(
                    expression = "8888888888 + 2313",
                    result = (8888888888 + 2313).toString(),
                    description = "user reported bug '8888888888 + 2313'",
                ),
                ValidEvaluationCase(
                    expression = "8888888888 + 2315",
                    result = (8888888888 + 2315).toString(),
                    description = "user reported bug '8888888888 + 2315'",
                ),/*
                ValidEvaluationCase(
                    expression = "7777777777 / 12356",
                    result = (7777777777 / 12356).toString(),
                    description = "user reported bug '7777777777 / 12356'",
                ),*/
                ValidEvaluationCase(
                    expression = "2 / 2",
                    result = (2 / 2).toString(),
                    description = "user reported bug '2 / 2'",
                ),
                ValidEvaluationCase(
                    expression = "3 / 2",
                    result = (3 / 2).toString(),
                    description = "user reported bug '3 / 2'",
                ),
                ValidEvaluationCase(
                    expression = "7777777778 / 12356",
                    result = (7777777778 / 12356).toString(),
                    description = "user reported bug '7777777778 / 12356'",
                ),

                ValidEvaluationCase(
                    expression = "7777777777 / 7777777777",
                    result = (7777777777 / 7777777777).toString(),
                    description = "user reported bug '7777777777 / 7777777777'",
                ),
                ValidEvaluationCase(
                    expression = "0.75995468 + 1",
                    result = (0.75995468 + 1).toString(),
                    description = "user reported bug '0.75995468 + 1'",
                ),
            )
        }

        @JvmStatic
        fun invalidEvaluationCases(): List<InvalidEvaluationCase> {
            return listOf(
                InvalidEvaluationCase(
                    expression = "-",
                    exceptionMessage = "Invalid expression",
                    description = "sign without number"
                ),
            )
        }
    }

    @MethodSource("validEvaluationCases")
    @ParameterizedTest
    fun `evaluate valid expression`(case: ValidEvaluationCase) {
        assertEquals(case.result, calculator.evaluate(case.expression))
    }

    @MethodSource("invalidEvaluationCases")
    @ParameterizedTest
    fun `invalid operation`(case: InvalidEvaluationCase) {
        val actualException = assertThrows<RuntimeException> {
            calculator.evaluate(case.expression)
        }

        assertEquals(actualException.message, case.exceptionMessage)
    }

    data class ValidEvaluationCase(
        val expression: String,
        val result: String,
        val description: String,
    )

    data class InvalidEvaluationCase(
        val expression: String,
        val exceptionMessage: String,
        val description: String,
    )
}
