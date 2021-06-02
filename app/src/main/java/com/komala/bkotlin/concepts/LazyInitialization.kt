package com.komala.bkotlin.concepts

import android.util.Log
import java.util.concurrent.CountDownLatch
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger

/*
We can pass the LazyThreadSafetyMode as an argument to the lazy function. The default publication mode is SYNCHRONIZED,
meaning that only a single thread can initialize the given object.

We can pass a PUBLICATION as a mode – which will cause that every thread can initialize given property.
The object assigned to the reference will be the first returned value – so the first thread wins.
 */

class LazyInitialization {

    var noOfInitializations: AtomicInteger = AtomicInteger()

    // by default - LazyThreadSafetyMode.PUBLICATION
    val lazyValue: DummyCl by lazy {
        noOfInitializations.incrementAndGet()
        DummyCl("BBK")
    }

    private fun mainMethod1() {
        //when
        Log.d("LazyInitialization1:    ", lazyValue.toString())
        Log.d("LazyInitialization2:    ", lazyValue.toString())

        // then
        //assertEquals(numberOfInitializations.get(), 1)  --> TRUE
    }


    val lazyValue2: DummyCl by lazy(LazyThreadSafetyMode.PUBLICATION) {
        noOfInitializations.incrementAndGet()
        DummyCl("")
    }

    private fun mainMethod2() {
        val executerService = Executors.newFixedThreadPool(5)
        val countDownLatch = CountDownLatch(1)

        //When
        executerService.submit {
            countDownLatch.countDown();
            Log.d("", lazyValue2.toString())
        }
        executerService.submit {
            countDownLatch.countDown();
            Log.d("", lazyValue2.toString())
        }

        //Then
        executerService.awaitTermination(1, TimeUnit.MILLISECONDS)
        executerService.shutdown()
        // assertEquals(numberOfInitializations.get(), 2)  --> TRUE
    }


}