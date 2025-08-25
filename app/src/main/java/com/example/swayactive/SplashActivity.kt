package com.example.swayactive

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.ScaleAnimation
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
// Import statement for LoginActivity is corrected for a standard project structure.
import com.example.swayactive.activities.LoginActivity

// SplashActivity is the entry point of your application. It displays a splash screen
// with a logo animation and then navigates to the next screen after a delay.
class SplashActivity : AppCompatActivity() {

    private val SPLASH_DURATION = 3000L; // 3 seconds, changed to a Long for Kotlin's postDelayed

    // Use lateinit var for views that are initialized in onCreate
    private lateinit var ivLogo: ImageView;
    private lateinit var tvAppTitle: TextView;
    private lateinit var mainContent: LinearLayout;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Hide action bar for a full-screen experience
        supportActionBar?.hide();

        initViews();
        startAnimations();
        navigateToNextScreen();
    }

    private fun initViews() {
        // Kotlin's findViewById is more concise
        ivLogo = findViewById(R.id.ivLogo);
        tvAppTitle = findViewById(R.id.tvAppTitle);
        mainContent = findViewById(R.id.mainContent);
    }

    private fun startAnimations() {
        // Create fade in + scale animation for the main content
        val animationSet = AnimationSet(true);

        // Fade in animation
        val fadeIn = AlphaAnimation(0.0f, 1.0f).apply {
            duration = 1500;
        };

        // Scale animation
        val scaleUp = ScaleAnimation(
            0.8f, 1.0f, 0.8f, 1.0f,
            Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f
        ).apply {
            duration = 1500;
        };

        animationSet.addAnimation(fadeIn);
        animationSet.addAnimation(scaleUp);

        // Start the animation
        mainContent.startAnimation(animationSet);
    }

    private fun navigateToNextScreen() {
        // Using a cleaner lambda for the postDelayed
        Handler(Looper.getMainLooper()).postDelayed({
            // Since MainDashboardActivity doesn't exist yet, we will always
            // navigate directly to the LoginActivity to prevent crashes.
            val intent = Intent(this@SplashActivity, LoginActivity::class.java);

            startActivity(intent);
            finish(); // Close splash activity
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }, SPLASH_DURATION);
    }
}
