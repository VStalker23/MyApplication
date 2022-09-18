package com.vladimirorlov.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import kotlin.concurrent.thread


class NotesActivity : AppCompatActivity() {

    private var chosenNote: Note? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val serviceIntent = Intent(this, NotesService::class.java)
        ContextCompat.startForegroundService(this, serviceIntent)
    }

    override fun onStart() {
        super.onStart()
        setButtonClickListener()
        createRecyclerView()
    }

    private fun displayPersonDetailsFragment(note: Note) {
        val noteItemFragment = NoteItemFragment()
        val bundle = bundleOf("thePersonAge" to note.description, "thePersonName" to note.title)
        noteItemFragment.arguments = bundle
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view, noteItemFragment)
            .commit()
    }

    private fun createNewNote(): Note {
        val noteTitle = findViewById<EditText>(R.id.note_title_et).text.toString()
        val noteDesc = findViewById<EditText>(R.id.note_desc_et).text.toString()
        val note = Note(noteTitle, noteDesc)
        thread(start = true) {
            Repository.getInstance(this).addNote(note)
        }
        return note
    }

    private fun setButtonClickListener() {
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val note = createNewNote()
            NotificationsManager.displayNewNoteNotification(this, note)
        }
    }

    private fun onNoteTitleClick(): (note: Note) -> Unit = {
        displayPersonDetailsFragment(it)
    }

    val getContentFromGallery =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            ImagesManager.onImageResultFromGallery(result, chosenNote!!, this)
        }

    private fun onNoteImageClick(): (note: Note) -> Unit = { note ->
        chosenNote = note
        ImagesManager.displayImagesAlertDialog(this, note, getContentFromGallery)
    }

    private fun createRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val adapter = MyAdapter(arrayListOf(), onNoteTitleClick(), onNoteImageClick(), this)
        recyclerView.adapter = adapter
        val notesListLiveData = Repository.getInstance(this).getAllNotesAsLiveData()
        notesListLiveData.observe(this) { notesList ->
            adapter.heyAdapterPleaseUpdateTheView(notesList)
        }
    }

}