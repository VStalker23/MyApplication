package com.vladimirorlov.myapplication


import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(
    private val dataList: ArrayList<Person>
) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = itemView.findViewById(R.id.item_name)
        val imageView: ImageView = itemView.findViewById(R.id.item_image)
        val removeBtn: ImageButton = itemView.findViewById(R.id.remove_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.class_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val person = dataList[position]

        holder.textView.text = person.name
        holder.imageView.setImageResource(person.image)

        holder.imageView.setOnClickListener {
            val dialog: AlertDialog.Builder = AlertDialog.Builder(it.rootView.context)
            val dialogView : View = LayoutInflater.from(it.rootView.context).inflate(R.layout.class_fragment, null)

            val dialogProfileImage: ImageView = dialogView.findViewById(R.id.fragment_class_image)
            val dialogProfileTitle: TextView = dialogView.findViewById(R.id.fragment_person_details)
            dialogProfileTitle.text = person.name
            dialogProfileImage.setImageResource(person.image)
            dialog.setView(dialogView)
            dialog.setCancelable(true)
            dialog.show()

        }

        holder.removeBtn.setOnClickListener {
            val builder = AlertDialog.Builder(holder.itemView.context)
            builder.setTitle("Delete item")
            builder.setMessage("Are you sure you want to delete?")
            builder.setPositiveButton("Confirm") { dialog, which ->
                dataList.removeAt(holder.layoutPosition)
                notifyItemRemoved(position)
            }
            builder.setNegativeButton("Cancel") { dialog, which ->
            }
            builder.show()
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun viewUpdater(personList: List<Person> ) {
        dataList.clear()
        dataList.addAll(personList)
        notifyDataSetChanged()
    }
}