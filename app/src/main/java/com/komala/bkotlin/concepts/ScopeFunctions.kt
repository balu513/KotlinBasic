package com.komala.bkotlin.concepts

import android.util.Log

//let, run, with, apply,also
open class ScopeFunctions {
    var mPerson: Person? = Person()
    fun scopeFunctionsCall() {
        letScopeFun()
        letListFilter()
        runScope()
        withScopeCall()
        applyScopeCall()
    }


    //'let' operator provides an option to perform an operation on the current object and return any value based on the use case.
    // current object is accessible through 'it'

    // by default return type is 'unit', if you return the specific value then 'let' return type will change to corrosponding type.
    // last statement would be the return type

    //inline fun <T, R> T.let(block: (T) -> R): R
    private fun letScopeFun() {
        var person: Person? = Person()

        val result = person?.let {
            it.name = "BALU_NEW"
            "new name is : ${it.name}"
        }

        val noOfCharacters = StringBuilder().let {
            it.append("Cows are of white or black color")
            it.append("Crows are of black color only")
            it.length
        }

    }

    private fun letWithElvis() {
        var color: String? = null
        val result = color?.let { "Color is : $color" } ?: "color is NULL"
        Log.d("ScopeFunctions:   let ", result)
    }

    private fun letListFilter() {
        listOf<Int>(1, 4, 5, 90, 4, 2, 67, 44, 9, 87, 88, 90).let {
            it.filter { it % 2 == 0 }.let { Log.d("ScopeFunctions letListFilter", it.toString()) }
        }
    }

    //inline fun <T, R> T.run(block: T.() -> R): R
    //The difference is run refers to the context of the object as “this” and not “it”.
    // That is the reason we did not use “${this.name}” as it would be redundant here since the block of code understands that “name”
    // is used here concerning the Person object.
    val runResult = mPerson?.run {
        name = "BBK"
        address = "Palasa"
        return@run this
    }

    private fun runScope() {
        Log.d("runScope :  ", runResult.toString())
    }

    //    So performing a null check using a “with” operator is difficult and
    //    this is where we can replace it with “run” as follows:
    //inline fun <T, R> with(receiver: T, block: T.() -> R): R
    var person: Person? = null
    var resultWith = with(receiver = person) {
        this?.name = "Komal"
        this?.contactNumber = "231231231"
        return@with this?.contactNumber + "is my new no"
    }

    private fun withScopeCall() {
        Log.d("withScope", resultWith)
    }

    //  The apply function is similar to the run functionality only in terms of referring to the context of the object as “this” and not “it”
    //and also in providing null safety checks:
//    We can see that run accepts a return statement whereas “apply” does not accept a return statement
    //inline fun T.apply(block: T.() -> Unit): T
    var resultApply = mPerson?.apply {
        name = "BBk"
        address = "Vizag"
    }

    private fun applyScopeCall() {
        Log.d("applyScope", resultApply.toString())
    }

    //    The “also” function is similar to the let functionality only in terms of referring to the context of the object as “it” and not “this”
//    and also in providing null safety checks:
//    inline fun T.also(block: (T) -> Unit): T
    var resultAlso = mPerson?.also {
        it.address = "Hyderabad"
    }


    private fun alsoScopeCall() {
        Log.d("alsoScope", resultAlso.toString())
    }


}