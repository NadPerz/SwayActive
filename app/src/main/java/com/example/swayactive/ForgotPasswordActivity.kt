package com.example.swayactive.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.swayactive.R

class ForgotPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.forgot_password)

        // Hide the action bar for a cleaner UI
        supportActionBar?.hide()

        // Find the back button and set a click listener
        val btnBack: ImageButton = findViewById(R.id.btnBack)
        btnBack.setOnClickListener {
            // This will navigate back to the previous activity in the back stack,
            // which is the LoginActivity in this case.
            onBackPressed()
        }

        // Find the "Send Code" button and set a click listener
        val btnSendCode: Button = findViewById(R.id.btnSendCode)
        btnSendCode.setOnClickListener {
            // Navigate to the OTP Verification screen
            val intent = Intent(this, OtpVerificationActivity::class.java)
            startActivity(intent)
        }
    }
}
