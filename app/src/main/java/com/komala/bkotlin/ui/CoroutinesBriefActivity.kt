package com.komala.bkotlin.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.komala.bkotlin.R
import com.komala.bkotlin.concepts.User
import com.komala.bkotlin.utility.Utility
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

// https://blog.mindorks.com/mastering-kotlin-coroutines-in-android-step-by-step-guide


/*
 CoroutineScope -->>
 Scopes in Kotlin Coroutines are very useful because we need to cancel the background task as soon as the activity is destroyed. Here,
  we will learn how to use scopes to handle these types of situations.

 Assuming that our activity is the scope, the background task should get canceled as soon as the activity is destroyed.

 In the activity, we need to implement CoroutineScope.

 GlobalScope ---->>
 When we need the global scope which is our application scope, not the activity scope, we can use the GlobalScope
 */
class CoroutinesBriefActivity : AppCompatActivity(), CoroutineScope {

    //these line of code for creating scope
    private lateinit var job: Job
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        job = Job()
        // these tasks will start in the onCreate()   and job.cancel() cancel the tasks in onDestroy
        launchDemo()
        usersExecuteParallel()



        setContentView(R.layout.activity_coroutines_brief_demo)
        findViewById<Button>(R.id.btnLaunch).setOnClickListener { launchDemo() }

        findViewById<Button>(R.id.btnAsync).setOnClickListener {
            usersExecuteParallel()
        }
        findViewById<Button>(R.id.btnWithContext).setOnClickListener {
            GlobalScope.async(Dispatchers.IO) { usersExecuteSeries() }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }


    /*
    As the fetchUserAndSaveInDatabase does not return anything, we can use the launch to complete that task and then do something on Main Thread.
    But when we need the result back, we need to use the async.
     */
    private fun launchDemo() {
        GlobalScope.launch(Dispatchers.IO) {
            Utility.fetchUserAndSaveInDatabase("launch")
        }

    }

    /*
    it makes both the network call in parallel, await for the results, and then calls the showUsers function.
     */
    private fun usersExecuteParallel() {
        GlobalScope.launch {
            val user1 = GlobalScope.async(Dispatchers.IO) { Utility.fetchFirstUser() }
            val user2 = GlobalScope.async(Dispatchers.IO) { Utility.fetchSecondUser() }
            Utility.showUsers(user1.await(), user2.await())
        }
    }

    /*
    withContext is nothing but another way of writing the async where we do not have to write await().
    Use withContext when you do not need the parallel execution.
     */
    private suspend fun usersExecuteSeries() {
        val user1 = withContext(Dispatchers.IO) { Utility.fetchFirstUser() }
        val user2 = withContext(Dispatchers.IO) { Utility.fetchSecondUser() }
        Utility.showUsers(user1, user2)

    }

    /*
    one way using try-catch
     */
    private fun exceptionHandlingUsingTryCatch() {
        GlobalScope.launch(Dispatchers.IO) {
            try {
                Utility.downloadMovie("BALU")
            } catch (e: Exception) {

            }
        }
    }

    /*
    another way of exception handling is . we can create the CoroutineExceptionHandler and add it to the scope.
     */

    val handler = CoroutineExceptionHandler { _, throwable ->
        Log.d(
            "Excepttion",
            throwable.message
        )
    }

    private fun exceptionHandlingUsingCoroutineExceptionHandler() {
        GlobalScope.async(Dispatchers.IO + handler) {
            Utility.fetchFirstUser()
        }
    }

    /*
     When using async, we need to use the try-catch block to handle the exception like below.
     */
    private suspend fun exceptionHandlingWithAsync() {
        val user1 = GlobalScope.async { Utility.fetchFirstUser() }

        try {
            user1.await()
        } catch (e: java.lang.Exception) {

        }
    }

    /*

         If one of the network calls fail, it will directly go to the catch block.
     */
    private suspend fun exceptionHandlingWithMultipleTasksInLaunchScope() {

        launch {
            try {
                Utility.fetchFirstUser()
                Utility.fetchSecondUser()

            } catch (e: java.lang.Exception) {

            }
        }

    }

    /*
    But suppose, we want to return an empty list for the network call which has failed and continue with the response from the other network call.
     We can add the try-catch block to the individual network call
     */
    private fun exceptionHandlingWithMultipleTasksInLaunchScope2() {
        launch {
            val usersList = try {
                Utility.getUsers()
            } catch (e: java.lang.Exception) {
                ArrayList()
            }
            val usersList2 = try {
                Utility.getMoreUsers()
            } catch (e: java.lang.Exception) {
                ArrayList()
            }
        }
    }


    /*
     if we want to make the network calls in parallel. We can write the code like below using async
     Here, we will face one problem, if any network error comes, the application will CRASH!, it will NOT go to the catch block.
     To solve this, we will have to use the coroutineScope
     */
    private fun exceptionHandlingWithMultipleTasksIn_Async_Scope() {

        this.launch {
            try {
                val dList1 = async { Utility.getUsers() }
                val dList2 = async { Utility.getMoreUsers() }
                val l1 = dList1.await()
                val l2 = dList2.await()

            } catch (e: java.lang.Exception) {

            }
        }

    }

    /*
    if any error comes it will go to catch block , wont CRASH
     */
    private fun exceptionHandlingWithMultipleTasksIn_Async_Scope_coroutineScope() {

        this.launch {
            try {
                coroutineScope {
                    val dList1 = async { Utility.getUsers() }
                    val dList2 = async { Utility.getMoreUsers() }
                    val l1 = dList1.await()
                    val l2 = dList2.await()
                }
            } catch (e: java.lang.Exception) {

            }
        }

    }

    /*
    But suppose again, we want to return an empty list for the network call which has failed and continue with the response from the other network call.
     We will have to use the supervisorScope and add the try-catch block to the individual network call like below:
     */
    private fun exceptionHandlingWithMultipleTasksIn_Async_Scope_supervisorScope() {
        launch {
            val d1 = async { Utility.getUsers() }
            val d2 = async { Utility.getMoreUsers() }

            val list1 = try {
                d1.await()
            } catch (e: java.lang.Exception) {
                ArrayList()
            }
            val list2 = try {
                d2.await()
            } catch (e: java.lang.Exception) {
                ArrayList()
            }
        }

    }
}