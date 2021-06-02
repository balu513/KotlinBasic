package com.komala.bkotlin.concepts

import android.util.Log
import kotlin.properties.Delegates
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/*

Lazy  -value gets computed only upon first access
observable/vetoable   - listeners get notified about changes to this property
Storing Properties in a Map (Instead of the separate field for each property)

1 - > private val textView: TextView by lazy { findViewByID(R.id.ll) }
We have initiated textView with a lazy delegate just for our safety so that there will be no null pointer exception while accessing it.

2 -> lets say when ever 'name' is called it should be modified with UPPER case, we can achieve this by setter and getter properties, but what if we need
same functionality for multiple properties ->  then delegations comes in picture., we need to create one custom delegate (like below TrimAppendDelegate)
and we need to set the fields wherever needed (private var collageName: String by TrimAppendDelegate())

3 -> we see the usage of lateinit var in our UI(Activities/Fragments) classes or View Models.
 We can use the concept of the lazy delegate in place of lateinit var. The variable will be initialized the first time it is used

4 -> We can use the inbuilt delegated property “Observable” to get the old and changed values of the data structure(list of objects)
We can also use this “Observable” property along with “lazy” for updating our views.
This can be very helpful if we are not using the concept of LiveData in our application


*/

class DelegationSample {

    val name: String by lazy { "findViewById[ BALU ] " }

    private var collageName: String by TrimAppendDelegate()
    private var list: ArrayList<DummyCl> = arrayListOf<DummyCl>(DummyCl("BALU"), DummyCl("SRI RAMA"))

    // whenever there is change in the 'users' then this observable trigger.
    private var users: ArrayList<DummyCl> by Delegates.observable(
        arrayListOf(),
        { kproperty, oldVal, newValue ->
            Log.d("Delegation kproperty", kproperty.name)
            Log.d("Delegation oldValue", oldVal.toString())
            Log.d("Delegation newValue", newValue.toString())
        })


    fun methodCall() {
        collageName = "Aditya Eng College    "
        Log.d("Delegation", collageName)
        var assign = users
        users.add(DummyCl("KK"))
    }

}

class TrimAppendDelegate : ReadWriteProperty<Any, String> {

    private var trimmedStr = "";

    override fun setValue(thisRef: Any, property: KProperty<*>, value: String) {
        trimmedStr = " My College is :  ${value.toUpperCase().trim()}"
    }

    override fun getValue(thisRef: Any, property: KProperty<*>): String {
        return trimmedStr
    }

}