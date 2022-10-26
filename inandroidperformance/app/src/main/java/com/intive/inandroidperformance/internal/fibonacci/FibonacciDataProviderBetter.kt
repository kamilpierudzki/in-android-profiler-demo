package com.intive.inandroidperformance.internal.fibonacci

import com.intive.inandroidperformance.internal.list.DataProvider

internal class FibonacciDataProviderBetter(
    private val fibonacciFormula: FibonacciFormula,
    private val currentComplexity: () -> Int,
) : DataProvider {

    private val handledPositions = mutableMapOf<Int, Boolean>()
    private var lastFibonacciValue: Int? = null

    override fun provideData(position: Int): Int {
        val nValue = currentComplexity()
        val handled = handledPositions[nValue]
        val lastValue = lastFibonacciValue
        return if (handled != null && handled && lastValue != null) {
            lastValue
        } else {
            val fibonacciValue = fibonacciFormula.calculate(nValue)
            lastFibonacciValue = fibonacciValue
            handledPositions.clear()
            handledPositions[nValue] = true
            fibonacciValue
        }
    }
}