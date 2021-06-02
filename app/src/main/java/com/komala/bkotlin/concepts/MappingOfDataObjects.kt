package com.komala.bkotlin.concepts

class MappingOfDataObjects {

    data class User(
        val firstName: String,
        val lastName: String,
        val street: String,
        val houseNumber: String,
        val phoneNumber: String,
        val age: Int,
        val password: String
    )

    data class UserView(
        val name: String,
        val address: String,
        val telephone: String,
        val age: Int
    )

    fun User.toUserView() = UserView(
        name = "$firstName   $lastName",
        address = "$houseNumber  $street",
        telephone = phoneNumber,
        age = age
    )

}