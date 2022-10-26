package com.intive.inandroidperformance.internal.fibonacci

import org.junit.Assert
import org.junit.Test

internal class FibonacciFormulaTest {

    @Test
    fun test1() {
        val tested = FibonacciFormula()

        Assert.assertEquals(1, tested.calculate(0))
        Assert.assertEquals(1, tested.calculate(1))
        Assert.assertEquals(1, tested.calculate(2))
        Assert.assertEquals(2, tested.calculate(3))
        Assert.assertEquals(3, tested.calculate(4))
        Assert.assertEquals(5, tested.calculate(5))
        Assert.assertEquals(8, tested.calculate(6))
        Assert.assertEquals(13, tested.calculate(7))
    }
}