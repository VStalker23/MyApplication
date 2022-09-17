package com.vladimirorlov.myapplication

import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class ClassFragment : Fragment(R.layout.person_fragment) {



    val classTextView =  activity?.findViewById<TextView>(R.id.fragment_person_details)
    val classImage =  activity?.findViewById<ImageView>(R.id.fragment_class_image)
    override fun onResume() {
        super.onResume()
        val classTextView = activity?.findViewById<TextView>(R.id.fragment_person_details)
        val classImage = activity?.findViewById<ImageView>(R.id.fragment_class_image)

        val name = requireArguments().getString("name")
        val image = requireArguments().getInt("image")

        classTextView?.text = name.toString()
        classImage?.setImageResource(image)
    }

//        private fun removePersonFragment() {
//            val fragment: Fragment? = activity?.supportFragmentManager?.findFragmentById(R.id.person_details_fragment)
//
//            removeFragment.setOnClickListener {
//
//                if (fragment != null) {
//                    activity?.supportFragmentManager?.beginTransaction()?.remove(fragment)?.commit()
//                }
//            }
//        }

}

