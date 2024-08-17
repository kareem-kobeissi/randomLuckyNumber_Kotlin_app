package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val b1 : Button = findViewById(R.id.btn)
        val txt: TextView = findViewById(R.id.textView)
        val editTXT: EditText = findViewById(R.id.editText)

        b1.setOnClickListener(){
            var username = editTXT.text
            // passing data
            var i = Intent(this, LuckyNumber::class.java)

            //passing username
            i.putExtra("name", username)

            startActivity(i)
        }
    }
}