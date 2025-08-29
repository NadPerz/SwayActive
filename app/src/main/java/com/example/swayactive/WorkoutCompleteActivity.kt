package com.example.swayactive.activities

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.swayactive.R

class WorkoutCompleteActivity : AppCompatActivity() {

    private lateinit var continueButton: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.workout_complete)

        // Hide action bar for full screen experience
        supportActionBar?.hide()

        initializeViews()
        setupClickListeners()
    }

    private fun initializeViews() {
        continueButton = findViewById(R.id.continueButton)
    }

    private fun setupClickListeners() {
        continueButton.setOnClickListener {
            // Close this activity and return to previous screen
            finish()
        }
    }

    override fun onBackPressed() {
        // Override back press to finish the activity
        super.onBackPressed()
        finish()
    }
}