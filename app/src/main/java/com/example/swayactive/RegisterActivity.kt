package com.example.swayactive.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.swayactive.R
// Corrected import statement to resolve the error.
import com.swayactive.activities.OnboardingWelcomeActivity

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Hide the action bar for a cleaner UI, just like in the login activity
        supportActionBar?.hide()

        // Find the "Login Now" TextView by its ID
        val tvLoginNow: TextView = findViewById(R.id.tvLoginNow)

        // Set an OnClickListener to handle the navigation back to the login page
        tvLoginNow.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish() // Optional: finish the current activity to remove it from the back stack
        }

        // Find the "Register" button by its ID
        val btnRegister: Button = findViewById(R.id.btnRegister)

        // Set an OnClickListener on the register button to navigate to the onboarding screen
        btnRegister.setOnClickListener {
            val intent = Intent(this, OnboardingWelcomeActivity::class.java)
            startActivity(intent)
            // It's a good idea to finish the RegisterActivity after a successful registration
            // so the user cannot go back to it.
            finish()
        }
    }
}
