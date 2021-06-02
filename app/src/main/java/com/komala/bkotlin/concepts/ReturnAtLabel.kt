package com.komala.bkotlin.concepts

import android.util.Log

class ReturnAtLabel {

    fun getAlternativeNumbers(list: List<Int>) {
    }

    fun <T> List<T>.printIndexOf(x: Int) {
        forEachIndexed { index, t ->
            if (t == x) {
                Log.d("printIndexOf", "Match the value $x at index $index")
            }
        }
    }

    fun <T> List<T>.matchValue(value: String) {

        //creating 'label' for the loop.
        forEach loop@{
            if ((it as String) == "abc") {
                // return from the LAMBDA
                return@loop
            }
            Log.d("ReturnAtLabel", "Value:  $it.toString()")
        }

    }

    fun <T> List<T>.matchValue2(value: String) {

        //creating 'label' for the loop.
        forEach loop@{
            if ((it as String) == "abc") {
                // return from function
                return
            }
            Log.d("ReturnAtLabel", "Value:  $it.toString()")
        }

    }
}