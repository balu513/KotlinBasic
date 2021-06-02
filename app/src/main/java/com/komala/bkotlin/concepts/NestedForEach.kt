package com.komala.bkotlin.concepts

import android.util.Log

class Country(val name: String, val cities: List<City>)

class City(val name: String, val streets: List<String>)

class World {

    private val streetsOfAmsterdam = listOf("Herengracht", "Prinsengracht")
    private val streetsOfBerlin = listOf("Unter den Linden", "Tiergarten")
    private val streetsOfMaastricht = listOf("Grote Gracht", "Vrijthof")
    private val countries = listOf(
        Country(
            "Netherlands", listOf(
                City("Maastricht", streetsOfMaastricht),
                City("Amsterdam", streetsOfAmsterdam)
            )
        ),
        Country("Germany", listOf(City("Berlin", streetsOfBerlin)))
    )


    fun allCountriesExplicit() {
//        countries.forEach { Log.d("allCountriesExplicit", it.toString()) }
        countries.forEach { country -> Log.d("allCountriesExplicit", country.toString()) }
    }

    // we can not able to access country and city details , inner side of the loop .
    fun allNested() {
        countries.forEach { it ->
            Log.d("World allNested : Address", it.cities.toString())
            it.cities.forEach {
                Log.d("World allNested : Address", it.name)
                it.streets.forEach { Log.d("World allNested : Address", it) }
            }
        }
    }

    // to achieve the above problem we need to point out the reference with with different identifier like here country, city, address
    fun allNestedTable() {
        countries.forEach { country ->
            country.cities.forEach { city ->
                city.streets.forEach { address ->
                    Log.d(
                        "World allNestedTable Address ", "country: " +
                                country.name + " city: " + city.name + " address: " + address
                    )
                }
            }
        }
    }

    fun allStreetsFlatMap() {
        countries.flatMap { it.cities }.flatMap { it.streets }
            .forEach { Log.d("World allStreetsFlatMap", it) }
    }

    private fun City.getStreetsWithCityName(): List<String> {
        val map = this.streets.map { "street name $it.name" }
        return map.toList()
    }

    fun Country.getCitiesWithCountryName(): List<String> {
        return cities.flatMap { it.getStreetsWithCityName() }
            .map { street -> "$name  $street" }
    }

}

class NestedForEach() {

    fun callNestedMethods() {
        World().allCountriesExplicit()
        World().allNested()
        World().allNestedTable()
        World().allStreetsFlatMap()
    }
}