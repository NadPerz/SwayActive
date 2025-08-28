package com.example.swayactive.activities

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.swayactive.R

class OnboardingHeightActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.onboarding_height)

        setupClickListeners()
    }

    private fun setupClickListeners() {
        // Back button click listener
        findViewById<androidx.cardview.widget.CardView>(R.id.btnBackCard).setOnClickListener {
            finish() // Go back to previous activity
        }

        // Next button click listener
        findViewById<LinearLayout>(R.id.btnNext).setOnClickListener {
            // Navigate to next onboarding screen
            // val intent = Intent(this, NextOnboardingActivity::class.java)
            // startActivity(intent)
        }
    }
}