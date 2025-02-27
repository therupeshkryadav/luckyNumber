package com.example.luckynumber

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {

    private lateinit var welcomeTxt: TextView
    private lateinit var luckyNoTxt: TextView
    private lateinit var shareBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Initialize views
        welcomeTxt = findViewById(R.id.textView2)
        luckyNoTxt = findViewById(R.id.luckyTxt)
        shareBtn = findViewById(R.id.shareBtn)

        // Get data from Intent
        val receivedIntent = intent
        val username = receivedIntent.getStringExtra("name") ?: "User"

        //Generating Random No.
        val random= generateRandomNumber()

        luckyNoTxt.text = random

        shareBtn.setOnClickListener {
            shareData(username,random)
        }
    }

    // Function to share a lucky number via other apps
    private fun shareData(username: String, random: String) {
        // Create an Intent with the action ACTION_SEND, which is used for sharing data
        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"  // Specifies that the data being shared is plain text

            // Put the text message in the intent with the recipient's name and lucky number
            putExtra(Intent.EXTRA_TEXT, "$username's Lucky Number is $random 🎉")
            putExtra(Intent.EXTRA_SUBJECT, "$username, Got Lucky Today!!")
        }

        // Start the sharing process by showing a chooser dialog
        // This allows the user to pick which app they want to share the text through
        startActivity(Intent.createChooser(intent, "Share via"))
    }


    // Function to generate a random lucky number
    private fun generateRandomNumber(): String {
        val random = (1..100).random()
        return random.toString() // Correct way to generate a random number
    }

}