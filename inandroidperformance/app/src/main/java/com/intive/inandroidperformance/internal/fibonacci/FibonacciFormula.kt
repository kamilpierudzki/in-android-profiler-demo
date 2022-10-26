package com.intive.inandroidperformance.internal.fibonacci

internal class FibonacciFormula {

    fun calculate(n: Int): Int = if (n > 2L) {
        calculate(n - 2) + calculate(n - 1)
    } else {
        1
    }
}