package com.komala.bkotlin.concepts

import android.util.Log

class OperatorOverloading {

    data class Point(var x: Int, var y: Int)


    operator fun Point.div(other: Point): Point {
        return Point(x / other.x, y / other.y)
    }

    operator fun Point.plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }

    operator fun <T> MutableCollection<T>.plusAssign(element: T) {
        this.add(element)
    }


    fun methodCall() {
        val p1 = Point(1, 8)
        val p2 = Point(3, 2)

        val p3 = p1 / p2
        val p4 = p1 + p2

        Log.d("OperatorOverloading", "$p3.toString()       $p4.toString()")

        val list = mutableListOf("Balu", "Kml")
        list += "Ram"

        Log.d("OperatorOverloading", list.toString())

    }
}
