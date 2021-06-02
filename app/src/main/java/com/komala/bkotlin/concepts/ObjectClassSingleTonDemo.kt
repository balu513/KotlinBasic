package com.komala.bkotlin.concepts

import java.io.Serializable

// SingleTon class can inherit other class, but single ton class cant't be inherit by other class.
// by default all the properties are public static final.

object ObjectClassSingleTonDemo : Serializable {

    //to access static field from JAVA. (if we give this annote then static field byte code will generate)
    @JvmStatic
    val staticField = 42

    private var id: Int = 1
    var name: String = "bk"
    fun displayColor(color: String): String {
        return when (color) {
            "red" -> "Red Color"
            "black" -> "Black Color"
            else -> "Other Color"
        }
    }
}

//In addition, objects can extend classes and implement interfaces. In doing so,
// they are effectively singleton instances of parent classes, exactly as expected.

//This can be very useful for cases where we have a stateless implementation and
// there’s no need for creating a new instance every time — e.g. Comparator:
object ObjectStringComp : Comparator<String> {
    override fun compare(p0: String?, p1: String?): Int {
        return p0!!.compareTo(p1!!)
    }
}
