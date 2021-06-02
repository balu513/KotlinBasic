package com.komala.bkotlin.concepts

import android.util.Log

// HigherOrderFunctions which can take do two things:
//Can take functions as parameters
//Can return a function
class HigherOrderFunctions {

    fun sumSquare(a: Int, b: Int): Int {
        return (a + b) * (a + b)
    }

    fun subtractSquare(a: Int, b: Int): Int {
        return (a - b) * (a - b)
    }

    var sumSqr: (Int, Int) -> (Int) = { a, b ->
        a + b * a + b
    }

    var subSqr: (Int, Int) -> (Int) = { a, b ->
        a - b * a - b
    }

    // function with functions are as parameters
    private fun getCalculation(
        value1: Int,
        value2: Int,
        sumSq: (Int, Int) -> (Int),
        subSq: (Int, Int) -> (Int)
    ): Int {

        var tempResult = value1 * value2
        val sumSq1 = sumSq(tempResult, 12)
        val subSqr1 = subSqr(tempResult, 9)

        return (tempResult + sumSq1 + subSqr1)

    }

    //Returning a function from Higher-Order function
    fun mul(a: Int, b: Int, c: Int): Int {
        return a * b * c
    }

    fun higherOrderFunc(): (Int, Int, Int) -> (Int) {
        return ::mul
    }

    fun callFun() {
        // argument as one Lambda function and one normal function
        val calculationValue = getCalculation(10, 12, sumSqr, ::subtractSquare)

        Log.d("HigherOrderFunctions Fun as Parameter:  ", calculationValue.toString())

        // function as return type
        val multiplyFun = higherOrderFunc()
        val multiplyFun1 = multiplyFun(12, 3, 6)

        Log.d("HigherOrderFunctions Fun as Return Type:  ", multiplyFun1.toString())
    }
}