package com.vladimirorlov.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("HackerU","onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun getMyName(): String {
        var name: String = "Vladimir"
        return name
    }

    fun onClick(view: View) {
        val textView: TextView = findViewById<TextView>(R.id.hello_text)
        val editTextCon = getEditText()
        textView.text = "Hello ${editTextCon} Good to see you in Android Studio for first time!"
    }

    fun getEditText(): String {
        val editText: EditText = findViewById(R.id.edit_text_first)
        return editText.text.toString()
    }
}
