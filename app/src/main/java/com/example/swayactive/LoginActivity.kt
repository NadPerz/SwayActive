package com.example.swayactive.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.swayactive.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()

        // Find the "Register Now" TextView and set its click listener
        val tvRegisterNow: TextView = findViewById(R.id.tvRegisterNow)
        tvRegisterNow.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        // Find the "Forgot Password?" TextView and set its click listener
        val tvForgotPassword: TextView = findViewById(R.id.tvForgotPassword)
        tvForgotPassword.setOnClickListener {
            val intent = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }

        // Add Login button click listener to navigate to MainDashboardActivity
        val btnLogin: Button = findViewById(R.id.btnLogin) // Assuming you have a login button with this ID
        btnLogin.setOnClickListener {
            // TODO: Add authentication logic here
            // For now, directly navigate to dashboard
            val intent = Intent(this, MainDashboardActivity::class.java)
            startActivity(intent)
            finish() // Close login activity so user can't go back with back button
        }
    }
}