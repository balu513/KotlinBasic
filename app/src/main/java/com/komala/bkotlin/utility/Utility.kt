package com.komala.bkotlin.utility

import android.util.Log
import com.komala.bkotlin.concepts.User
import kotlinx.coroutines.Deferred

class Utility {
    companion object {
        fun getConceptsList(): List<String> {
            var list: ArrayList<String> = ArrayList<String>()
            list.add("Hilt Dagger")
            list.add("KotlinCollectionFunctions")
            list.add("Generics")
            list.add("Destructuring Declarations")
            list.add("Sealed Classes")
            list.add("Delegation")
            list.add("Main Method calls")
            list.add("Scope Functions")
            list.add("Nested ForEach")
            list.add("OperatorOverloading")
            list.add("EnumsDemo")
//            list.add("Kotlin Basics")
//            list.add("Basic Types")
//            list.add("Control Flow")
//            list.add("Class & Object")
//            list.add("Constructors")
//            list.add("Inheritance")
//            list.add("Interface")
//            list.add("Visibility Control")
//            list.add("Extension")
//            list.add("Data Classes")
//            list.add("Sealed Class")
//            list.add("Generics")
//            list.add("Delegation")
//            list.add("Functions")
//            list.add("Destructuring Declarations")
//            list.add("Exception Handling")
            return list
        }

        fun fetchUserAndSaveInDatabase(taskName: String) {
            Log.d("Task Started", "task name:  $taskName")
            Thread.sleep(2000)
            Log.d("Task Ended", "task name:  $taskName")

        }

        fun downloadMovie(taskName: String): String? {
            Log.d("Task Started", "task name:  $taskName")
            Thread.sleep(2000)
            Log.d("Task Ended", "task name:  $taskName")

            return "Task: $taskName  downloaded successfully"

        }

        fun getUsersList(): List<User> {
            return arrayListOf(
                User(10, "Balakrishna Balli"),
                User(11, "Komal"),
                User(12, "Rama"),
                User(13, "Surya"),
                User(14, "Samsung"),
                User(15, "NoKIA"),
                User(16, "Apple"),
                User(17, "DBS"),
                User(18, "CISCO"),
                User(19, "Dell"),
                User(20, "JP Morgan"))

        }

        fun fetchFirstUser(): User {
            // make network call
            return User(1, "BK")
        }

        fun fetchSecondUser(): User {
            return User(2, "BALU")
        }

        fun getUsers(): List<User> {
            return ArrayList()
        }

        fun getMoreUsers(): List<User> {
            return ArrayList()
        }

        fun showUsers(user1: User, user2: User) {
            //todo
        }
    }

}