package com.komala.bkotlin.concepts

import android.util.Log
import kotlin.system.measureTimeMillis

class ElapsedTimeMeasure {

    val elapsed = measureTimeMillis {
        Thread.sleep(1000)
        Log.d("measureTimeMillis", "Measuring time via measureTimeMillis")
    }
}