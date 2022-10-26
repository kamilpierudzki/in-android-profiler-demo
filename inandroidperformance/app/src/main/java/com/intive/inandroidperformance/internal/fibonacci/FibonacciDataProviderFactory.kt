package com.intive.inandroidperformance.internal.fibonacci

import com.intive.inandroidperformance.internal.ProviderType
import com.intive.inandroidperformance.internal.list.DataProvider

internal class FibonacciDataProviderFactory(
    private val currentComplexity: () -> Int,
    private val fibonacciFormula: FibonacciFormula = FibonacciFormula()
) {

    fun create(providerType: ProviderType): DataProvider {
        return when (providerType) {
            ProviderType.BAD -> FibonacciDataProviderBad(fibonacciFormula, currentComplexity)
            ProviderType.BETTER -> FibonacciDataProviderBetter(fibonacciFormula, currentComplexity)
        }
    }
}