package com.komala.bkotlin.concepts

import android.util.Log

/*
Only data classes will support Destructuring Declarations
val(id,name,employer) = Employee(101,"Balu","DBS")


if you want to add the destructuring functionality to a class that doesn’t support it,
then just implement the corresponding componentN operator function. Make sure you prefix them with the operator keyword.
 */
data class Employee(var id: Int, var name: String, var employer: String)

class Student(var sName: String, var branch: String)

class Faculty(var fName: String, var teachingExp: Int) {
    operator fun component1(): Any {
        return fName
    }

    operator fun component2(): Any {
        return teachingExp
    }
}

class DestructuringDeclarations {


    fun readEmployee() {
        val (id, name, employer) = Employee(101, "Balu", "DBS")

        val employee2 = Employee(102, "Kml", "Wirpo")
        val (_, name1, employer1) = employee2

        Log.d("DestructuringDeclarations", "id $id,  name : $name,  employer: $employer")
        Log.d("DestructuringDeclarations", "name : $name1,  employer: $employer1")
    }

    fun readPair() {
        var pair1: Pair<Student, Faculty> = Pair(Student("Balu", "CSE"), Faculty("Ravikanth", 10))
        var (student, faculty) = pair1
        Log.d(
            "DestructuringDeclarations Student & Faculty Pair: ",
            "stunt name : ${student.sName}  faculty name: ${faculty.fName}"
        )

    }

    fun hasMapReadWithDestructuringDeclarations() {
        var hMap: HashMap<Int, String> = HashMap()
        hMap.put(1, "Sri Rama")
        hMap.put(2, "Lord Siva")

        for ((id, name) in hMap) {
            Log.d("DestructuringDeclarations hasMapRead", "id: $id   name: $name")
        }
    }

    fun readNormalClassWithDestructuringDeclarations() {
        val faculty = Faculty("Boss", 4)
        val (name, exp) = faculty
        Log.d("DestructuringDeclarations readNormalClass", "exp: $exp   fName: $name")
    }

    fun methodCall() {
        readEmployee()
        readPair()
        hasMapReadWithDestructuringDeclarations()
        readNormalClassWithDestructuringDeclarations()
    }
}