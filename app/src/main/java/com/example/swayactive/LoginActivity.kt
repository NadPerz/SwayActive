package com.example.swayactive.activities

import android.content.Intent
import android.os.Bundle
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
    }
}
