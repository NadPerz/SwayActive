package com.example.swayactive.activities

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.swayactive.R
import com.example.swayactive.activities.OnboardingWeightActivity

/**
 * OnboardingWelcomeActivity is the first screen of the onboarding process.
 * It displays a welcome message and a button to start the journey.
 */
class OnboardingWelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.onboarding_welcome)

        // Find the "Start Now" button layout by its ID
        val btnLetsStart: LinearLayout = findViewById(R.id.btnLetsStart)

        // Set an OnClickListener to handle the navigation to the next onboarding screen
        btnLetsStart.setOnClickListener {
            // Create an Intent to navigate to the OnboardingWeightActivity
            val intent = Intent(this, OnboardingWeightActivity::class.java)
            startActivity(intent)
            // It's good practice to finish the current activity so the user
            // can't go back to the welcome screen after starting the onboarding process.
//            finish()
        }
    }
}
