package com.vladimirorlov.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun getMyName(): String {
        var name: String = "Vladimir"
        name = "Dani"
        return name
    }

    fun onClick(view: View) {
        val textView: TextView = findViewById<TextView>(R.id.hello_text)
        textView.text = "Hello ${getMyName()} Good to see you in Android Studio for first time!"
    }
}
