package com.example.swayactive.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.swayactive.R

// LoginActivity will be responsible for displaying the login UI.
// You will implement the login logic (e.g., button clicks) here later.
class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // This line links the Java file with your XML layout file.
        // It tells Android to display the UI you designed in activity_login.xml.
        setContentView(R.layout.activity_login)

        // Optional: Hide the action bar for a cleaner, full-screen look
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        // TODO: In a later step, you will add code here to handle button clicks
        // and other user interactions on the login screen.
    }
}