package com.vladimirorlov.myapplication

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NotesDao {

    @Insert
    fun insertNote(note: Note)

    @Delete
    fun delete(note: Note)

    @Query("Select * from notesTable")
    fun getAllNotes(): LiveData<List<Note>>

    @Update
    fun updateNote(note: Note)

    fun updateNoteImage(note: Note, imagePath: String, imageType: IMAGE_TYPE){
        note.imagePath = imagePath
        note.imageType = imageType
        updateNote(note)
    }

}