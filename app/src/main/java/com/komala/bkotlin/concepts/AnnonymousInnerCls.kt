package com.komala.bkotlin.concepts

class AnnonymousInnerCls {

    val obj = object : ILogin {
        override fun loginSuccess() {
            TODO("Not yet implemented")
        }

        override fun loginFailure() {
            TODO("Not yet implemented")
        }

        override fun timeOut() {
            TODO("Not yet implemented")
        }

        override fun noInternetConnection() {
            TODO("Not yet implemented")
        }

    }

    val maxEntries = 100

    val lruCache = object : LinkedHashMap<String, Int>() {
        override fun removeEldestEntry(eldest: MutableMap.MutableEntry<String, Int>?): Boolean {
            return maxEntries > this.size
        }

    }

    //    we can create anonymous inner classes without even extending another class or interface:
    val obj1 = object {
        val name = "BK"
        var id: Int = 10
            get() = id

        open fun getId1(): Int {
            return id * 10
        }

    }

//    fun callMethodforObj1() {
//        obj1.getId1()
//    }

}