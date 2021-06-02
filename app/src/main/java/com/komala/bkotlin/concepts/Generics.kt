package com.komala.bkotlin.concepts

import android.util.Log

class ParameterizedClass<A>(private val value: A) {

    fun getA(): A {
        return value
    }
}

class Generics {
    fun methodCall() {
        val parameterizedClass = ParameterizedClass<String>("Balu")
        Log.d("parameterizedClass", "${parameterizedClass.getA()} ")

        val value = ParameterizedProducer<String>("Ram").getValue()
        Log.d("ParameterizedProducer String", value)

        val intValue = ParameterizedProducer<Int>(12).getValue()
        Log.d("ParameterizedProducer String", intValue.toString())

        val parameterizedConsumer = ParameterizedConsumer<Long>()
        val toString = parameterizedConsumer.toString(456L)
        Log.d("ParameterizedConsumer", toString)
    }
}

/*
Let’s say that we want to create a producer class that will be producing a result of some type T.
Sometimes; we want to assign that produced value to a reference that is of a supertype of the type T.

To achieve that using Kotlin, we need to use the out keyword on the generic type. It means that we can assign this reference
 to any of its supertypes. The out value can be only be produced by the given class but not consumed:
 */
class ParameterizedProducer<out T>(private val value: T) {
    fun getValue(): T {
        return value
    }
}

class ParameterizedConsumer<in T> {
    fun toString(value: T): String {
        return value.toString()
    }
}
