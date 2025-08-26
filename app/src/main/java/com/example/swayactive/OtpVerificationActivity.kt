package com.example.swayactive.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.swayactive.R

class OtpVerificationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.otp_verification)

        // Hide the action bar for a cleaner UI
        supportActionBar?.hide()

        // Find the "Resend" TextView and set a click listener
        val tvResend: TextView = findViewById(R.id.tvResend)
        tvResend.setOnClickListener {
            // This will navigate back to the previous activity in the back stack,
            // which is the ForgotPasswordActivity in this case.
            onBackPressed()
        }

        // Find the "Verify" Button and set a click listener to navigate
        // to the Create Password screen.
        val btnVerify: Button = findViewById(R.id.btnVerify)
        btnVerify.setOnClickListener {
            val intent = Intent(this, CreatePasswordActivity::class.java)
            startActivity(intent)
        }
    }
}
