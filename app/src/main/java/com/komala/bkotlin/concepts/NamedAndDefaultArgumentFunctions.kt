package com.komala.bkotlin.concepts

import android.util.Log

open class NamedAndDefaultArgumentFunctions {

    // positional parameters
    fun resize(newSize: Int, forceSize: Int, animation: Boolean) {
        Log.d(
            "NamedAndDefaultArgumentFunctions",
            "newSize: $newSize forceSize: $forceSize animation: $animation"
        )
    }

    open fun setColor(
        colorCode: Int,
        animation: Boolean = true,
        newColorHue: String = "#453dde"
    ) {
        Log.d(
            "NamedAndDefaultArgumentFunctions",
            " colorCode:  $colorCode animation: $animation newColorHue:  $newColorHue"
        )

    }

    fun mainCall() {
        //positional arguments should pass in the same order
        resize(10, 12, false)

        //named arguments , we can pass any order
        resize(animation = false, newSize = 10, forceSize = 19)

        // default arguments not mandatory to pass
        setColor(100)

        setColor(39, newColorHue = "HRS", animation = false)

        setColor(89, newColorHue = "Tgh")
    }


}