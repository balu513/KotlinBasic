package com.komala.bkotlin.concepts

import android.util.Log

class VarargsAndSpreadOperators {

    //we can pass zero or more parameters to a vararg argument
    fun sum(vararg xs: Int): Int = xs.sum()

    fun printStrings(vararg vs: String) {
        vs.forEach { str -> Log.d("VarargsAndSpreadOperators", str) }
    }

    //Sometimes we have an existing array instance in Kotlin, and we want to pass it to a function accepting a vararg.
    // In those situations, to decompose the array to a vararg, we can use the spread operator:
    fun spreadOperator() {
        var numbers = intArrayOf(1, 2, 3, 4)
//        var sum  = sum(numbers)
        var sum = sum(*numbers)
        Log.d("VarargsAndSpreadOperators", sum.toString())
    }

    fun createUser(vararg roles: String, id: Long, name: String) {
        roles.forEach { role -> Log.d("VarargsAndSpreadOperators", role) }
        Log.d("VarargsAndSpreadOperators id", "id: $id")
        Log.d("VarargsAndSpreadOperators name ", "name $name")
    }

    fun mainCall() {
        val sum = sum()  // output: 0
        val sum1 = sum(2, 3, 4, 1)  // 10
        createUser("Developer, Tester, Programmer", name = "Balu", id = 513)
    }
}