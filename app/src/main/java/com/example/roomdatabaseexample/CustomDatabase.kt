package com.example.roomdatabaseexample

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Contact::class], version = 1)
abstract class CustomDatabase: RoomDatabase() {
    abstract fun contactDao(): ContactDao
}