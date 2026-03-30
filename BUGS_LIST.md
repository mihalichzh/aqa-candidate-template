### Bugs
1. Explicit '+' num sign support is missing  e.g.:
```
    1. Put expression with explicit num sign, e.g.: +2 + 3
    Expected: Handled properly, 5 is returned.
    Actual: RuntimeExpression is thrown.
```
2. Non-descritive error message for case with only-sign expression passed, e.g. '-':
```
org.opentest4j.AssertionFailedError: expected: <Unexpected token ''.> but was: <Invalid operation>
```
3. StackOverflow error on specific evaluation case: '8888888888 + 2314':
```
1. Evaluate: '8888888888 + 2314'

Expected result: evaluation processed correctly, sum of numbers printed.
Actual result: error is thrown, see stacktrace.
'''
2026-03-30T08:43:40.024956205Z     java.lang.StackOverflowError
2026-03-30T08:43:40.024957080Z         at com.aqa.interview.calculator.privateimpl.PrivateExpressionCalculator.infiniteRecursion(PrivateCalculatorRuntimeProvider.kt:46)
2026-03-30T08:43:40.024960914Z         at com.aqa.interview.calculator.privateimpl.PrivateExpressionCalculator.infiniteRecursion(PrivateCalculatorRuntimeProvider.kt:46)
'''
```
