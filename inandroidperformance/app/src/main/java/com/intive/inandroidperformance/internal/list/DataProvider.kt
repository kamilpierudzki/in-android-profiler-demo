package com.intive.inandroidperformance.internal.list

interface DataProvider {
    fun provideData(position: Int): Int
}