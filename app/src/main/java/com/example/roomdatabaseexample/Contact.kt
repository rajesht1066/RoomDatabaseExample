package com.example.roomdatabaseexample

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contact")
data class Contact(
    @PrimaryKey(autoGenerate = true) val uid:Int,
    @ColumnInfo(name = "name") val name:String,
    @ColumnInfo(name = "phoneNumber") val phoneNumber:String
)
