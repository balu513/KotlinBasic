package com.komala.bkotlin.concepts

import androidx.lifecycle.Transformations.map

//Kotlin allows some functions to be called without using the period and brackets. These are called infix methods,
//and their use can result in code that looks much more like a natural language.

//For example, the mockito-kotlin library defines some infix functions — doAnswer, doReturn, and doThrow — for use when defining mock behavior.

//The function is either defined on a class or is an extension method for a class
//The function takes exactly one parameter
//The function is defined using the infix keyword
class InfixFunctions {

    // 'to' is infix function
    var map = mapOf(1 to "Balu", 2 to "Ram")

}

class Assertion<T>(private val target: T) {

//    infix fun isEqualTo(other: T) {
//        Assert.assertEquals(other, target)
//    }

//    infix fun isDifferentFrom(other: T) {
//        Assert.assertNotEquals(other, target)
//    }

//val result = Assertion(5)
//
//result isEqualTo 5 // This passes
//result isEqualTo 6 // This fails the assertion
//result isDifferentFrom 5 // This also fails the assertion

    infix fun String.substringMatches(r: Regex): List<String> {
        return r.findAll(this).map {
            val value = it.value
            value
        }.toList()
    }

    infix fun String.indexOfMy(other: String): Int {
        val indexOf = this.indexOf(other)
        return indexOf
    }

    fun callMet() {
        val list = "abc dfe 123 balu balli" substringMatches "sd".toRegex()
        val i = "abc def ghi jkl" indexOfMy "h"
    }

}