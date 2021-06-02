package com.komala.bkotlin.concepts

open interface ILogin {

    fun loginSuccess()
    fun loginFailure()
    fun timeOut()
    fun noInternetConnection()
}