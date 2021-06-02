package com.komala.bkotlin.concepts

import android.util.Log

data class User(val id: Int, val name: String)
data class Contact(val name: String, val ph: String)

class KotlinCollectionFunctions {
    var listContacts = listOf(
        Contact("Balu", "9493955155"),
        Contact("Surya", "123456709"),
        Contact("Surya1", "1234542346709"),
        Contact("Surya876", "123300456709"),
        Contact("Su3242rya", "123233456709")
    )
    val users = arrayOf(
        User(1, "Amit"),
        User(2, "Ali"),
        User(3, "Sumit"),
        User(4, "Himanshu")
    )
    val mixList = listOf(1, "Balu", 90F, 35, 98, "A", "Hello", "KT", false, "Ra", 999)
    var listNames: List<String> =
        listOf("Balu", "Kml", "Ram", "Seetha", "laxhman", "Anja", "Ravana", "Ram", "Seetha", "Kml")
    var listIds =
        listOf(1, 5, 8, 9, 3, 11, 12, 1, 9, 8, 76, 89, 45, 32, 12, 76, 67, 555, 77, 88, 1, 92)
    var listIds2 =
        listOf(1, 5, 8, 9, 3, 11, 900, 65, 888, 1111, 455, 90, 60, 20, 10, 3, 5)
    val ktFunctions = listOf(
        "distinct", "map", "isEmpty", "contains", "filter", "first", "last", "reduce",
        "single", "joinToString"
    )


    fun functionCalls() {
        removeDuplicates()
        convertArrayOrListToString()
        transformACollectionIntoASingleResult()
        findIfAllElementsSatisfyingAParticularCondition()
        findAnElementBasedOnParticularCondition()
        break_your_list_into_multiple_sublists_of_smaller_size()
        copyOfArray()
        associatedDataUsingSomeKey()
        distinct_union_intersection()
        zip()
    }

    private fun removeDuplicates() {
        val distinctList = listIds.distinctBy { id -> id * 100 }.map { id -> " id: $id" }
        Log.d("KotlinCollectionFunctions removeDuplicates", distinctList.joinToString())
    }

    private fun convertArrayOrListToString() {
        val joinToString =
            ktFunctions.joinToString(",", "Mentioned KT functions - ", "are very useful", 5, "etc")
        Log.d("KotlinCollectionFunctions joinToString", joinToString)
    }

    private fun transformACollectionIntoASingleResult() {
        val result = listIds.reduceRight { res, item -> item + res }
        Log.d("KotlinCollectionFunctions transformACollectionIntoASingleResult", result.toString())
    }

    private fun findIfAllElementsSatisfyingAParticularCondition() {
        val allEven = listIds.all { it % 2 == 0 }
        Log.d(
            "KotlinCollectionFunctions findAllElementsSatisfyingAParticularCondition",
            allEven.toString()
        )
    }


    //The 'find' returns the first element matching the given condition or null if no such element was found.

    //While 'single' returns the single element matching the given condition or it will throw an exception if there are more than
    // one matching element or no matching element in the list.
    private fun findAnElementBasedOnParticularCondition() {
        val find = users.find { it.id == 3 }
        val single = users.single { it.id == 2 }
        Log.d(
            "KotlinCollectionFunctions findAnElementBasedOnParticularCondition",
            "find: ${find?.toString()}  single: $single"
        )
    }

    private fun break_your_list_into_multiple_sublists_of_smaller_size() {
        val chunked = listIds.chunked(4)
        Log.d(
            "KotlinCollectionFunctions break_your_list_into_multiple_sublists_of_smaller_size",
            chunked.joinToString()
        )
//        listIds.chunked(3, a)
    }

    private fun copyOfArray() {
        var arr1 = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        var arr2 = arrayOf(11, 12, 13, 14, 15, 16, 17, 18, 19, 20)
        arr1.copyInto(arr2, 2, 3, 7)
        Log.d("KotlinCollectionFunctions array 2", arr2.joinToString())
    }

    private fun associatedDataUsingSomeKey() {
        val associateWith = listContacts.associateWith { it.ph }
        Log.d("KotlinCollectionFunctions associatedDataUsingSomeKey", associateWith.toString())
    }

    private fun distinct_union_intersection() {
        val distinct = listIds.distinct()
        val union = listIds.union(listIds2)
        val intersect = listIds.intersect(listIds2)

        Log.d("KotlinCollectionFunctions distinct", distinct.joinToString())
        Log.d("KotlinCollectionFunctions distinct", union.joinToString())
        Log.d("KotlinCollectionFunctions distinct", intersect.joinToString())

    }

    /*
    If in a collection, you want to keep the specified elements only then you can use retainAll function.
    Since this function will modify your list, so make sure that your list or array is mutable.

    retainAll will return true if any element is removed from the collection otherwise it will return false.
     */
    private fun keepTheSpecifiedElementsOnly() {
        val listOne = mutableListOf(1, 2, 3, 3, 4, 5, 6)
        val listTwo = listOf(1, 2, 3, 3, 4, 5, 6)
        val listThree = listOf(1, 2, 3, 3, 4, 5, 7)

        listOne.retainAll(listTwo)  //false
        listOne.retainAll(listThree) //true
        println(listOne) // [1, 2, 3, 3, 4, 5]
    }

    private fun filterACollectionBasedOnCondition() {
        val filter = listIds.filter { it % 2 == 1 }
        Log.d("KotlinCollectionFunctions filterACollectionBasedOnCondition", filter.joinToString())
    }

    private fun filterACollectionBasedOnIndexBased() {
        val filter = listIds.filterIndexed { index, _ -> listIds[index] % 2 == 0 }
        Log.d("KotlinCollectionFunctions filterACollectionBasedOnCondition", filter.joinToString())
    }

    private fun filterACollectionBasedOnIndexBasedOnInstance() {
        val filterIsInstance = mixList.filterIsInstance<String>()
        Log.d(
            "KotlinCollectionFunctions filterACollectionBasedOnIndexBasedOnInstance",
            filterIsInstance.joinToString()
        )
    }

    /*
    zip returns a list of pairs. The first element of the pair will be taken from the first collection and the second element of the pair will be
     taken from the second collection. The size of the returned list will be equal to the size of the shortest collection.
     */
    private fun zip() {
        val list1 = listOf(1, 3, 5, 7, 2, 4, 6, 0, 11, 4)
        val list2 = listOf("Bal", "a", "b", "d", "tt", "xy")
        val zip = list1.zip(list2)
        Log.d("KotlinCollectionFunctions zip", zip.joinToString())
    }

    private fun zipWithNext() {
        val list1 = listOf(1, 2, 3, 4, 5, 6)
        val zipWithNext = list1.zipWithNext() //[(1,2),(2,3),(3,4),(4,5),(5,6)]
        Log.d("KotlinCollectionFunctions zipWithNext", zipWithNext.joinToString())
    }

    private fun unzip() {
        val mp = listOf("a" to 1, "b" to 2, "c" to 3, "r" to 10, "x" to 99)
        //val unzip = mp.unzip()
        val (names, ids) = mp.unzip()
        Log.d(
            "KotlinCollectionFunctions unzip",
            "names: ${names.joinToString()}  ids: ${ids.joinToString()}"
        )
    }

    private fun splitArrayIntoTwoPartsBasedOnCondition() {
        val (res1, res2) = listIds.partition { it % 2 == 0 }
        Log.d("KotlinCollectionFunctions splitArrayIntoTwoPartsBasedOnCondition",
            "res1: ${res1.joinToString()}  res2: ${res2.joinToString()}")
    }

    /*
    The reversed() function can be applied on Array, List, and MutableList. It generates a new list that is the reverse of the original list.

    But the asReversed() function can be applied on List and MutableList. It doesn't generate a new list because, after reversal, the new elements
    are still referring to the old one. So any change in one of them will result in a change in the other one.
     */
    private fun reverseList() {
        val reversed = listIds.reversed()  // result assigned to new list
        listIds.asReversed()  // result assigned back to same list ref
        Log.d(
            "KotlinCollectionFunctions reverseList",
            "reversed: ${reversed.joinToString()}  asReversed: ${listIds.joinToString()}"
        )
        listIds.asReversed()
    }

    private fun groupElementsBasedOnSomeCondition() {
        val groupBy = listIds.groupBy { it % 3 == 0 }
    }

}