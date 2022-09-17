package com.vladimirorlov.myapplication

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ClassDao {

    @Insert
    fun insertClass(person: Person)

    @Delete
    fun deleteClass(person: Person)

    @Query("Select * from classTable")
    fun getAllPeople(): LiveData<List<Person>>

}