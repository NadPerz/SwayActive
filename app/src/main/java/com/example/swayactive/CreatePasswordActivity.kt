package com.example.swayactive.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.swayactive.R

class CreatePasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_password)

        // Hide the action bar for a cleaner UI
        supportActionBar?.hide()

        // Find the "Reset Password" button and set a click listener
        val btnResetPassword: Button = findViewById(R.id.btnResetPassword)
        btnResetPassword.setOnClickListener {
            // Navigate back to the LoginActivity and clear the back stack
            val intent = Intent(this, LoginActivity::class.java)
            // This flag will clear all the activities on top of LoginActivity,
            // so the user cannot go back to the password reset flow.
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

        // TODO: In a later step, you will add code here to handle the password reset logic.
    }
}
