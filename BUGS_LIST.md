### Bugs
1. Explicit '+' num sign support is missing  e.g.:
```
    1. Put expression with explicit num sign, e.g.: +2 + 3
    Expected: Handled properly, 5 is returned.
    Actual: RuntimeExpression is thrown.
```
