package com.sourcepad.armory.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar

class MainActivity : AppCompatActivity() {

    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
