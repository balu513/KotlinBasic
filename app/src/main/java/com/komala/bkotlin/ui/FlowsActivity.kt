package com.komala.bkotlin.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.komala.bkotlin.R
import com.komala.bkotlin.concepts.User
import com.komala.bkotlin.utility.Utility
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.coroutines.CoroutineContext

/*
Coroutine is just the scheduler part of RxJava
but now with Flow APIs coming along side it, it can be alternative to RxJava in Android

Flow API in Kotlin is a better way to handle the stream of data asynchronously that executes sequentially.

So, in RxJava, Observables type is an example of a structure that represents a stream of items.
Its body does not get executed until it is subscribed to by a subscriber. and once it is subscribed,
subscriber starts getting the data items emitted.
Similarly, Flow works on the same condition where the code inside a flow builder does not run until the flow is collected.
 */
class FlowsActivity : AppCompatActivity(), CoroutineScope {
    lateinit var job: Job
    lateinit var flow: Flow<Int>
    lateinit var flowOp: Flow<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flows)
        job = Job()
        job.start()
        setupFlow()
        setupClicks()
        setupFlowWithOperators()
        flowBuilder_flowOf()
    }

    /*
    flowOf() - It is used to create flow from a given set of values
     */
    private fun flowBuilder_flowOf() {
//        flow<Int> { emit() }
        val flowOf = flowOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
        flowOf{

        }
        flowOf.onEach {

        }.filter { it > 5 }
        flowOf.flowOn(Dispatchers.IO)
        launch {
            flowOf.collect { result ->
                Log.d("Flows flowBuilder_flowOf: ", result.toString())
            }
        }
    }

    /*
    We will emit numbers from 0 to 10 at 500ms delay.
    To emit the number we will use emit() which collects the value emitted. It is part of FlowCollector which can be used as a receiver.
    and, at last, we use flowOn operator which means that shall be used to change the context of the flow emission. Here,
    we can use different Dispatchers like IO, Default, etc.
    NOTE:   flowOn() is like subscribeOn() in RxJava
     */
    private fun setupFlow() {
        flow = flow {
            Log.d("", "Flow Started")
            (0..10).forEach { value ->
                kotlinx.coroutines.delay(500)
                Log.d("Flows emitting: ", value.toString())
                emit(value)
            }
        }.flowOn(Dispatchers.IO)

    }

    private fun setupFlowWithOperators() {
        flowOp = flow {
            Utility.getUsersList().forEachIndexed { index, user ->
                emit(user)
            }
        }.flatMapMerge { it ->
            flow {
                it.takeIf {
                    it.name.length > 5
                }
                emit(it)
            }
        }.flowOn(Dispatchers.IO)

        launch {
            flowOp.collect {
                Log.d("Flows : setupFlowWithOperators", "name: ${it.name}  id: ${it.id}")
            }
        }
    }

    /*
    flow.collect now will start extracting/collection the value from the flow on the Main thread as Dispatchers.Main is used in
    launch coroutine builder in CoroutineScope
     */
    private fun setupClicks() {
        launch(Dispatchers.IO) {
            flow.collect {
                Log.d("Flows : collected: ", it.toString())
            }
        }

    }

    private val handler = CoroutineExceptionHandler { _, throwable ->
        Log.d(
            "CoroutineExceptionHandler",
            throwable.message
        )
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job + handler

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }
}