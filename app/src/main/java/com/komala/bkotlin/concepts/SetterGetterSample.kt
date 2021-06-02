package com.komala.bkotlin.concepts

import android.util.Log
import kotlin.system.measureTimeMillis

//https://www.baeldung.com/kotlin/getters-setters

internal class SetterGetterSample {

    var brand: String = "SAMSUNG"
        private set
        get

    private var name: String
        get() = name
        set(value) {
            name = value
        }
    private var id: Int
        get() = id
        set(value) {
            id = value
        }

    private var message: String
        get() = message
        set(value) {
            message = when {
                value > "Balu" -> "Balakrishna Balli"
                value > "Komal" -> "Komali Sri"
                else -> "Nothing"
            }
        }

    //Backing Fields   --> compiler generates 'field' (called back field) for the header property 'statusCode'
    private var statusCode: Int = 100
        get() = statusCode
        set(value) {
            if (value == 404 || value in 500..600)
                field = value
        }

}

//Kotlin compiler generates a getter for the body property, and both a getter and setter for the headers property.
// Under the hood, Kotlin will use a Java field to store the property values.
// These Java fields are known as backing fields in the Kotlin world.

data class HttpResponse(val body: String, var headers: Map<String, String>)