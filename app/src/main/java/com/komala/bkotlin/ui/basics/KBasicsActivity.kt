package com.komala.bkotlin.ui.basics

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.komala.bkotlin.R
import java.io.IOException

class KBasicsActivity : AppCompatActivity() {

    var tv: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kbasics)
        tv = findViewById<TextView>(R.id.tv_k_basics)
        ifHandling()
        arrayOf()
        setAndMap()
        forLoopHandling()
        namedArgumentsDefaultParameterValues()
        val value = tryCatchReturnValue()
        Log.d("tryCatchReturnValue", "return value is :  $value")

        lambdas()
        mapWithLambdas()
        lambdasAsClassExtensions()
        returningFromALambda()


    }

    private fun returningFromALambda(): (Int) -> String {
        val calculateGrade = { grade: Int ->
            when (grade) {
                in (1..5) -> "very good"
                in (6..10) -> "good"
                in (11..20) -> "Avg"
                in (21..100) -> "worse"
                else -> "dirty"
            }
        }
        return calculateGrade
    }

    private fun lambdasAsClassExtensions() {
        val extendString = extendString("Balu ", 513)
        Log.d("lambdasAsClassExtensions", extendString)
    }

    private fun extendString(value1: String, value2: Int): String {

        //String.(Int) -> classExtension
        val another: String.(Int) -> String = { this + it }

        return value1.another(value2)
    }

    private fun mapWithLambdas() {
        val list = (1..20).toList()
        val listOfBirds = listOf<String>("Parrot", "Crow", "Crane", "Sparrow", "Bat", "Abc")
        var mapResult = list.map { item -> item * item }
        Log.d("mapWithLambdas", mapResult.joinToString())

        val takeUnlessResult = listOfBirds.takeIf { it.contains("Crow") }
        Log.d("mapWithLambdas takeUnless ", takeUnlessResult?.joinToString())
    }

    private fun lambdas() {
        var timesTwo = { x: Int -> x * 2 }
        Log.d("Lambda ", timesTwo(10)?.toString())

        val add: (Int, Int, Float) -> String = { a: Int, b: Int, c: Float ->
            (a + b + c).toString()
        }
        var result: String = add(10, 89, 98.4f)
        Log.d("Lambda", result)


        var list = (1..100).toList()
        val filter = list.filter { item -> item % 2 == 0 }
        Log.d("Lambda", filter.toString())

        var oddNums = list.filter { it.odd() }
        Log.d("Lambda ODD nos", oddNums.toString())
//        Log.d("Lambda ODD nos", list.filter { ::odd })

    }

    private fun isEven(i: Int) = i % 2 == 0

    //Extensions
    private fun Int.odd() = this % 2 == 1


    private fun tryCatchReturnValue(): String {
        var res = try {
            getExternalInput()
            "try"
        } catch (e: IOException) {
            "IOException: " + e.message
        } finally {
            Log.d("tryCatchReturnValue", "finally")
        }
        return res
    }

    fun getExternalInput(): IOException {
        throw IOException("Could not read file")
    }

    private fun namedArgumentsDefaultParameterValues() {
        var result = concat2(listOf("Red", "Blue", "Green", "Black", "White"))
        Log.d("namedArgumentsDefaultParameterValues", result)

        //arguments with different order also will map based on namespace (maps with parameter name)
        var result2 = concat(separator = " ^^ ", list = listOf("ABC", "DEF", "MNO", "PQR", "XYZ"))
        Log.d("namedArgumentsDefaultParameterValues", result2)

    }

    fun concat(list: List<String>? = null, separator: String = " <#> "): String? {
        return list?.joinToString(separator)
    }

    fun concat2(list: List<String>?, separator: String = " @ ") = list?.joinToString(separator)

    private fun forLoopHandling() {
        for (i in 1..10) {
            Log.d("forLoopHandling", i.toString())
        }
        for (c in "BALU") {
            Log.d("forLoopHandling", c.toString())
        }
        var birds = listOf<String>("Parrot", "Crow", "Crane", "Sparrow")
        for (bird in birds) {
            Log.d("forLoopHandling", bird)
        }
        for (i in 10 downTo 1) {
            Log.d("forLoopHandling", i.toString())
        }
        for (i in 10 downTo 1 step 2) {
            Log.d("forLoopHandling", i.toString())
        }
    }

    private fun setAndMap() {
        val setData = setOf(1, 2, 5, 8, 5, 2, 4, 9, 11, 2, 4, 546, 6)
        Log.d("setAndMap", setData.joinToString())
//        setDatap[2] = 90

        val mutableSetData = mutableSetOf(1, 2, 5, 8, 5, 2, 4, 9, 11, 2, 4, 546, 6)
//        mutableSetData[2] = 100
        Log.d("setAndMap", mutableSetData.joinToString())

        val mapOf = mapOf(Pair(1, "B"), Pair(36, "Sw"), Pair(13, "BB"))
        Log.d("mapOf", mapOf.entries.joinToString())
        //mapOf[36] = "RAM"
    }

    private fun arrayOf() {
        val arr = arrayOf(1, 2, 6, 7, 100, 23, 34, -98, 33)
        tv?.text = arr.joinToString()
        tv?.text = arr[1].toString()
        val lis =
            listOf<String>("abc", "xyeeza", "xqasdasdyza", "_xywq", "_bvcq323xyza#", "xyrrrqweza")
        Log.d("arrayOf", lis.joinToString())
        val mList =
            mutableListOf("abc", "xyeeza", "xqasdasdyza", "_xywq", "_bvcq323xyza#", "xyrrrqweza")
        mList[2] = "BALU"
        // lis[2] = "Balu"
        Log.d("mutableListOf", mList.joinToString())
    }

    private fun ifHandling() {
        var i = 10
        val x = if (i > 10) {
            i = i + 10
            "Value is more than 10"
            "BBK"
        } else {
            i = i - 10
            "Value is less than 10"
            "BSK"

        }
        tv.let { it?.text = x }
    }

}
