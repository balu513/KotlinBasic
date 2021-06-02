package com.komala.bkotlin.concepts

class Person() {
    var name: String = "Abcd Old"
    var contactNumber: String = "1234567890 Old"
    var address: String = "xyz Old"
    fun displayInfo() = print(
        "\n Name: $name\n " +
                "Contact Number: $contactNumber\n " +
                "Address: $address"
    )

}