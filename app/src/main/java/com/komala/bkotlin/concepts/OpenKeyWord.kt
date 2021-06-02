package com.komala.bkotlin.concepts

import android.util.Log

// by default all the classes, properties and members of classes are final
//if we want to extend class or override methods or fields we should make it as 'open'

open class Color {

    open var name: String = "Balu"

    open fun getColor(colorCode: Int, gradient: Boolean = false): String {
        return "red";
    }
}

// extending class  && overriding properties and functions
class Sub(override var name: String) : Color() {

    override fun getColor(colorCode: Int, gradient: Boolean): String {
        return "Blue"
    }

    fun methodCall() {
        var obj = Sub("Rama")
        obj.getColor(gradient = true, colorCode = 56)
        Log.d("Sub", obj.name)
    }

}