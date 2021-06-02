package com.komala.bkotlin.concepts

import android.util.Log

class NamedAndDefaultArgumentFunctionsSub : NamedAndDefaultArgumentFunctions() {

    //This is not allowed and results in a compiler error. Overriding functions cannot specify default values for their parameters.
    // Kotlin requires that default values can only be specified in the base class functions.
//    override fun setColor(colorCode: Int,
//                          animation: Boolean = true,
//                          newColorHue: String){
//
//    }

    // Default
    override fun setColor(
        colorCode: Int,
        animation: Boolean,
        newColorHue: String
    ) {
        Log.d(
            "NamedAndDefaultArgumentFunctions",
            " colorCode:  $colorCode animation: $animation newColorHue:  $newColorHue"
        )
    }

    fun subMethod() {
        resize(newSize = 10, animation = false, forceSize = 133)
        setColor(122, newColorHue = "5324dd")
    }

}