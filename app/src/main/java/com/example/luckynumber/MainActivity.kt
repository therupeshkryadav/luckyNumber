package com.example.luckynumber

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Initialize widget using
        val inputTxt: EditText = findViewById(R.id.inputName)
        val myButton: Button = findViewById(R.id.wishBtn)

        myButton.setOnClickListener {
            val username = inputTxt.text.toString()

            //Explicit Intent
            val intent = Intent(applicationContext,SecondActivity::class.java)

            //Passing the name to the next Activity
            intent.putExtra("name",username)

            startActivity(intent)
        }
    }
}