package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class LuckyNumber : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lucky_number)

        val text1 : TextView = findViewById(R.id.text1)
        val luckyText: TextView = findViewById(R.id.luckNum)
        val shareBtn: Button = findViewById(R.id.button)

        var user_name = recieveUserName()


        var random_num = generateRandomNum()
        luckyText.setText(""+random_num)
        shareBtn.setOnClickListener(){
            shareData(user_name, random_num)
        }

    }

    fun recieveUserName():String{
        var bundle: Bundle? = intent.extras
        var username = bundle?.get("name").toString()
        return username
    }

    //Random nbs generator
    fun generateRandomNum(): Int{
        val random = Random.nextInt(1000)
        return random
    }

    //sharing the username and number

    fun shareData(username: String, num : Int){

        // implicit Intents

        var i = Intent(Intent.ACTION_SEND)
        i.setType("text/plain")
        i.putExtra(Intent.EXTRA_SUBJECT,  "$username is lucky today")
        i.putExtra(Intent.EXTRA_TEXT, "His luck number is $num")
        startActivity(i)

    }

}