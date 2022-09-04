package com.vladimirorlov.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private var classList = arrayListOf<ClassSelector>()
    var adapter = RecyclerAdapter(classList)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setButtonClickListener()
    }


    private fun setButtonClickListener() {
        val button = findViewById<Button>(R.id.add_button)
        val input = findViewById<EditText>(R.id.class_name_input)

        button.setOnClickListener {

            val radioGroup = findViewById<RadioGroup>(R.id.radioItemSelect)
            val checkedId =  radioGroup.checkedRadioButtonId
            adapter.notifyDataSetChanged()

            if (input.text.isNullOrEmpty())
                Toast.makeText(this, "Please enter a valid Input", Toast.LENGTH_SHORT).show()

            else {
                if (checkedId == -1)
                    Toast.makeText(this,"Please select an image class!", Toast.LENGTH_SHORT).show()

                when(checkedId) {
                    R.id.radioButton1 -> classList.add(ClassSelector(input.text.toString(),R.drawable.dk))
                    R.id.radioButton2 -> classList.add(ClassSelector(input.text.toString(),R.drawable.druid))
                    R.id.radioButton3 -> classList.add(ClassSelector(input.text.toString(),R.drawable.mage))
                }
            }
        }

        createRecyclerView()
    }
    private fun createRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = adapter
    }
}

