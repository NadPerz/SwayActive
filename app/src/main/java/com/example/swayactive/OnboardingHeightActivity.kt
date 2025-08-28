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
        supportActionBar?.hide()

        setupClickListeners()
    }

    private fun setupClickListeners() {
        // Back button click listener
        findViewById<androidx.cardview.widget.CardView>(R.id.btnBackCard).setOnClickListener {
            finish() // Go back to previous activity
        }

        // Next/Start button click listener - Navigate to MainDashboardActivity
        findViewById<LinearLayout>(R.id.btnNext).setOnClickListener {
            // Navigate to the main dashboard (assuming this is the last onboarding step)
            val intent = Intent(this, MainDashboardActivity::class.java)
            startActivity(intent)

            // Clear the activity stack so user can't go back to onboarding
            finishAffinity()
        }
    }
}