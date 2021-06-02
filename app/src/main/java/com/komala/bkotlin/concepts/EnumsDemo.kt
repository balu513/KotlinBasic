package com.komala.bkotlin.concepts

import android.util.Log
import com.komala.bkotlin.concepts.EnumsDemo.Week.FRI

class EnumsDemo {

    enum class Week {
        SUN, MON, TUE, WED, THU, FRI, SAT
    }

    enum class Month(val mon: Int) {
        JAN(1), FEB(2), MAR(3), APR(4)
    }

    enum class CardType(var color: String) {
        SILVER("grey"), GOLD("yellow"), PLATINUM("black")
    }

    interface ICardLimit {
        fun getCardLimit(): Long
    }

    enum class CardType1 : ICardLimit {
        SILVER {
            override fun getCardLimit(): Long {
                return 100000L
            }
        },
        GOLD {
            override fun getCardLimit() = 1200000L
        }
    }

    fun callMeth() {
        Log.d("EnumsDemo Week", FRI.name + "  " + FRI.toString())
        Log.d("EnumsDemo Month", Month.FEB.name + "   " + Month.FEB.mon)
        Log.d("EnumsDemo with overridden meth: ", CardType1.GOLD.getCardLimit().toString())

        for (cardType in CardType.values()) {
            Log.d("EnumsDemo", cardType.name + "  " + cardType.color)
        }
    }
}