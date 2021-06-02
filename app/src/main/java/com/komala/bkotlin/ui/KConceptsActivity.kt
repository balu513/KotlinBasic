package com.komala.bkotlin.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.komala.bkotlin.R
import com.komala.bkotlin.ui.adapter.KConceptsAdapter
import com.komala.bkotlin.concepts.*
import com.komala.bkotlin.ui.basics.KBasicsActivity
import com.komala.bkotlin.utility.Utility.Companion.getConceptsList

class KConceptsActivity : AppCompatActivity(), KConceptsAdapter.OnKConceptClickedListener {
    private var recyclerView: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recycler_view_concepts)
        recyclerView?.layoutManager = LinearLayoutManager(applicationContext)
        recyclerView?.adapter = KConceptsAdapter(getConceptsList(), this)
    }

    override fun onKConceptClicked(concept: String) {
        when (concept) {
            "KotlinCollectionFunctions" -> {
                KotlinCollectionFunctions().functionCalls()
            }
            "Generics" -> {
                Generics().methodCall()
            }
            "Destructuring Declarations" -> {
                DestructuringDeclarations().methodCall()
            }
            "Sealed Classes" -> {
                MainMethodClass().sealedClassMethodCall()
            }
            "Delegation" -> {
                DelegationSample().methodCall()
            }
            "Main Method calls" -> {
                MainMethodClass().main()
            }
            "Scope Functions" -> {
                ScopeFunctions().scopeFunctionsCall()
            }
            "Nested ForEach" -> {
                NestedForEach().callNestedMethods()
            }
            "EnumsDemo" -> {
                EnumsDemo().callMeth()
            }
            "OperatorOverloading" -> {
                OperatorOverloading().methodCall()
            }
            "Kotlin Basics" -> {
                startActivity(Intent(applicationContext, KBasicsActivity::class.java))
            }
            "Basic Types", "Control Flow" -> {
            }

            "Class & Object" -> {
            }
            "Constructors" -> {
            }
            "Inheritance" -> {
            }
            "Interface" -> {
            }
            "Visibility Control" -> {
            }
            "Extension" -> {
            }
            "Data Classes" -> {
            }
            "Sealed Class" -> {
            }
            "Generics" -> {
            }
            "Delegation" -> {
            }
            "Functions" -> {
            }
            "Destructuring Declarations" -> {
            }
            "Exception Handling" -> {
            }

        }
    }
}