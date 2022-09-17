package com.vladimirorlov.myapplication

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "classTable")
data class Person(
    @ColumnInfo(name = "class_name") val name: String,
    @ColumnInfo(name = "class_image") val image: Int,
) {
    @PrimaryKey(autoGenerate = true)
    var id = 0
}