package com.example.roomdatabaseexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.room.Room
import com.example.roomdatabaseexample.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var database: CustomDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        database = Room.databaseBuilder(applicationContext,CustomDatabase::class.java,"contactDB").build()

        binding.button.setOnClickListener {
            GlobalScope.launch {
                database.contactDao().insertContact(Contact(0,"Rajesh","6301318277"))
            }
        }

        database.contactDao().getAll().observe(this@MainActivity, Observer {
            Log.d("check",it.toString())

        })
        binding.button2.setOnClickListener {
           // GlobalScope.launch {

            //}
        }

        binding.button5.setOnClickListener {
            GlobalScope.launch {
                database.contactDao().updateContact(Contact(1,"Rajesh","9515935447"))
            }
        }

        binding.button4.setOnClickListener {
            GlobalScope.launch {
                database.contactDao().deleteContact(Contact(1,"Rajesh","6301318277"))
            }
        }
    }
}