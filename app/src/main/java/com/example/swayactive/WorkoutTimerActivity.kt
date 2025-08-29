package com.example.swayactive.activities

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.swayactive.R

class WorkoutTimerActivity : AppCompatActivity() {

    private lateinit var btnBack: ImageView
    private lateinit var btnProfile: ImageView
    private lateinit var timerText: TextView
    private lateinit var circularProgressBar: ProgressBar
    private lateinit var pauseButton: FrameLayout  // Changed from LinearLayout to FrameLayout
    private lateinit var workoutTitle: TextView
    private lateinit var workoutSubtitle: TextView

    private var countDownTimer: CountDownTimer? = null
    private var timeLeftInMillis: Long = 5000 // 5 seconds
    private var isTimerRunning = false
    private var isPaused = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.workout_timer)
        supportActionBar?.hide()

        initializeViews()
        setupClickListeners()
        startTimer()
    }

    private fun initializeViews() {
        btnBack = findViewById(R.id.btnBack)
        btnProfile = findViewById(R.id.btnProfile)
        timerText = findViewById(R.id.timerText)
        circularProgressBar = findViewById(R.id.circularProgressBar)
        pauseButton = findViewById(R.id.pauseButton)
        workoutTitle = findViewById(R.id.workoutTitle)
        workoutSubtitle = findViewById(R.id.workoutSubtitle)

        // Set initial progress bar max
        circularProgressBar.max = 100
        circularProgressBar.progress = 0
    }

    private fun setupClickListeners() {
        btnBack.setOnClickListener {
            finish()
        }

        btnProfile.setOnClickListener {
            // TODO: Open profile or settings
        }

        pauseButton.setOnClickListener {
            if (isTimerRunning) {
                pauseTimer()
            } else {
                resumeTimer()
            }
        }
    }

    private fun startTimer() {
        countDownTimer = object : CountDownTimer(timeLeftInMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timeLeftInMillis = millisUntilFinished
                updateTimerText()
                updateProgressBar()
            }

            override fun onFinish() {
                // Timer finished
                timeLeftInMillis = 0
                updateTimerText()
                circularProgressBar.progress = 100
                isTimerRunning = false

                // Navigate to workout completion screen
                navigateToWorkoutComplete()
            }
        }

        countDownTimer?.start()
        isTimerRunning = true
    }

    private fun pauseTimer() {
        countDownTimer?.cancel()
        isTimerRunning = false
        isPaused = true
        // TODO: Update pause button icon to play icon
    }

    private fun resumeTimer() {
        startTimer()
        isPaused = false
        // TODO: Update pause button icon back to pause icon
    }

    private fun updateTimerText() {
        val minutes = (timeLeftInMillis / 1000) / 60
        val seconds = (timeLeftInMillis / 1000) % 60
        val timeFormatted = String.format("%02d:%02d", minutes, seconds)
        timerText.text = timeFormatted
    }

    private fun updateProgressBar() {
        val totalTime = 5000L // 5 seconds total
        val progress = ((totalTime - timeLeftInMillis) * 100 / totalTime).toInt()
        circularProgressBar.progress = progress
    }

    override fun onDestroy() {
        super.onDestroy()
        countDownTimer?.cancel()
    }

    override fun onPause() {
        super.onPause()
        if (isTimerRunning) {
            pauseTimer()
        }
    }

    override fun onResume() {
        super.onResume()
        if (isPaused && !isTimerRunning) {
            // Timer was paused, user can choose to resume
        }
    }

    private fun navigateToWorkoutComplete() {
        val intent = Intent(this, WorkoutCompleteActivity::class.java)
        startActivity(intent)
        finish() // Close current timer activity
    }
}