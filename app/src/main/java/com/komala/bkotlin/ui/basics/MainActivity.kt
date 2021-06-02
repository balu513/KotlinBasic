package com.komala.bkotlin.ui.basics

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.komala.bkotlin.R
import com.komala.bkotlin.ui.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }

    fun kotlinConceptsClick(view: View) {
        startActivity(Intent(this,KConceptsActivity::class.java))
    }
    fun coroutinesClicked(view: View) {
        startActivity(Intent(this,CoroutinesBriefActivity::class.java))
    }
    fun flowsClicked(view: View) {
        startActivity(Intent(this,FlowsActivity::class.java))
    }

    fun kotlinBasicsClick(view: View) {
        startActivity(Intent(this,KBasicsActivity::class.java))
    }

    fun cameraCapture(view: View) {
        startActivity(Intent(this,CameraCaptureWithIntentActivity::class.java))
    }

    fun cameraCapture2(view: View) {
        startActivity(Intent(this, CameraCaptureWithCameraAPIActivity::class.java))
    }
}