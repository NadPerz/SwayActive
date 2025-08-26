package com.swayactive.activities

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.swayactive.R

/**
 * OnboardingWelcomeActivity is the first screen of the onboarding process.
 * It displays a welcome message and a button to start the journey.
 */
class OnboardingWelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.onboarding_welcome)
    }
}
