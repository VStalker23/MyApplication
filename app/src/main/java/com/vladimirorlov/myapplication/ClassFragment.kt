package com.vladimirorlov.myapplication

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class ClassFragment : Fragment(R.layout.class_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val personTextView =  activity?.findViewById<TextView>(R.id.fragment_class_details)
        val personImage =  activity?.findViewById<ImageView>(R.id.fragment_class_image)

        val name = requireArguments().getString("name")
        val image = requireArguments().getInt("image")

        personTextView?.text = name.toString()
        personImage?.setImageResource(image)
    }

}