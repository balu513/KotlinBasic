package com.komala.bkotlin.concepts

import java.lang.Exception

/*
enum class Result(val message: String) {
    SUCCESS("Success"),
    ERROR(val exception: Exception) // not possible with enums
}
Sealed classes are advanced to Enum Classes , Enum wont mantien state of the object, where as Sealed classes did that.
Sealed classes are


Subclasses of a sealed class, as discussed, are either ordinary classes, data classes or sealed classes themselves
and hence it is easy to contain the state of the subclass.

Why Sealed Class over Abstract Class?
Sealed classes are abstract by itself, and cannot be instantiated directly. So let’s take a pause here.
If Sealed classes are abstract by default, why can’t we use an abstract class instead of a sealed class in the first place? Well, the catch here is
an abstract class can have their hierarchies anywhere in the project, whereas a sealed class should contain all the hierarchies in the same file.

with in same file its existing so kotlin at compile time it knows how many sub instances with sealed class so, no 'else' block required.
 */

sealed class SealedNetWorkResponse
data class NetworkState(var state: Boolean) : SealedNetWorkResponse()
data class Success(var msg: String, var statusCode: String) : SealedNetWorkResponse()
data class Failure(var exception: Exception, var statusCode: String) : SealedNetWorkResponse()

