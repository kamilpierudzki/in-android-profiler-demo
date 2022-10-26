package com.intive.inandroidperformance.internal.fibonacci

import com.intive.inandroidperformance.internal.list.DataProvider

internal class FibonacciDataProviderBad(
    private val fibonacciFormula: FibonacciFormula,
    private val currentComplexity: () -> Int,
) : DataProvider {

    override fun provideData(position: Int): Int {
        return fibonacciFormula.calculate(currentComplexity())
    }
}