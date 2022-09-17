package com.vladimirorlov.myapplication

import android.app.Application
import androidx.lifecycle.LiveData

class Repository(application: Application) {
    private val dao = ClassDatabase.getDatabase(application).getNotesDao()

    fun getAllPeopleAsLiveData(): LiveData<List<Person>> {
        return dao.getAllPeople()
    }

    fun addPerson(person: Person) {
        dao.insertClass(person)
    }
}