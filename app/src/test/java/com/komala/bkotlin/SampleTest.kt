package com.komala.bkotlin

import org.junit.Test
import java.lang.NullPointerException
import kotlin.test.assertFailsWith

class SampleTest {

    @Test
    fun nullPointerExceptionThrow() {
        assertFailsWith<NullPointerException> {
            var name: String? = null
            name!!.length
        }

    }
}