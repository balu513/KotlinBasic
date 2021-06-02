package com.komala.bkotlin.concepts

class AllTogether {

    //Elvis operator or ternary operator
    private fun ternaryOperator(a: String?) {
        //if a is non null returns the 'a' else return right side of '?:' message
        val result = a ?: "its a Null value"
    }

}