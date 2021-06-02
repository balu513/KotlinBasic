package com.komala.bkotlin.concepts

import android.util.Log
import com.komala.bkotlin.concepts.ObjectClassSingleTonDemo.name
import java.lang.NullPointerException

open class MainMethodClass {

    fun main() {
        val displayColor = ObjectClassSingleTonDemo.displayColor("red")
        val name2 = name

        val names = listOf<String>("Surya", "Bk", "Kml", "Ram")
        val sortedNames = names.sortedWith(ObjectStringComp)
        Log.d("MainMethodClass Sorted names: ", sortedNames.joinToString())
    }

    fun sealedClassMethodCall() {
        val success = Success("Login Success Dude!", "0000")
        handleLoginAPIResponse(success)

        handleLoginAPIResponse(Failure(NullPointerException("Null received"),"9999"))
    }

    private fun handleLoginAPIResponse(response: SealedNetWorkResponse) {
        when (response) {
            is Success -> {
                Log.d("Sealed", "Success ${response.msg}")
            }
            is Failure -> {
                Log.d("Sealed", "Failure ${response.exception.localizedMessage}")
            }
            is NetworkState -> {
                Log.d("Sealed", "NetworkState ${response.state}")

            }

        }

    }


}