package com.vladimirorlov.myapplication

import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class ClassFragment : Fragment(R.layout.class_fragment) {

    private lateinit var removeFragment: ImageButton


    val personTextView =  activity?.findViewById<TextView>(R.id.fragment_class_details)
    val personImage =  activity?.findViewById<ImageView>(R.id.fragment_class_image)
    override fun onResume() {
        super.onResume()
        val personTextView = activity?.findViewById<TextView>(R.id.fragment_class_details)
        val personImage = activity?.findViewById<ImageView>(R.id.fragment_class_image)
//            removeFragment = activity?.findViewById(R.id.remove_fragment)!!

        val name = requireArguments().getString("name")
        val image = requireArguments().getInt("image")

        personTextView?.text = name.toString()
        personImage?.setImageResource(image)
//            removePersonFragment()
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