package com.example.swayactive.activities

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.swayactive.R
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import de.hdodenhof.circleimageview.CircleImageView
import java.util.*

class MainDashboardActivity : AppCompatActivity() {

    private lateinit var profileImage: CircleImageView
    private lateinit var searchIcon: ImageView
    private lateinit var menuIcon: ImageView
    private lateinit var scheduleMenuIcon: ImageView
    private lateinit var gridNavIcon: ImageView
    private lateinit var greetingText: TextView
    private lateinit var calorieCount: TextView
    private lateinit var startWarmupButton: TextView
    private lateinit var calorieChart: LineChart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_dashboard)

        // Hide action bar for full screen experience
        supportActionBar?.hide()

        initializeViews()
        setupGreeting()
        setupCalorieChart()
        setupClickListeners()
    }

    private fun initializeViews() {
        // Header views
        profileImage = findViewById(R.id.profileImage)
        searchIcon = findViewById(R.id.searchIcon)
        menuIcon = findViewById(R.id.menuIcon)

        // Content views
        greetingText = findViewById(R.id.greetingText)
        calorieCount = findViewById(R.id.calorieCount)
        calorieChart = findViewById(R.id.calorieChart)

        // Schedule views
        scheduleMenuIcon = findViewById(R.id.scheduleMenuIcon)
        startWarmupButton = findViewById(R.id.startWarmupButton)

        // Navigation views
        gridNavIcon = findViewById(R.id.gridNavIcon)
    }

    private fun setupGreeting() {
        val calendar = Calendar.getInstance()
        val hourOfDay = calendar.get(Calendar.HOUR_OF_DAY)

        val greeting = when (hourOfDay) {
            in 0..11 -> "Good morning,\nnadija"
            in 12..16 -> "Good afternoon,\nnadija"
            else -> "Good evening,\nnadija"
        }

        greetingText.text = greeting
    }

    private fun setupCalorieChart() {
        // Sample data for the week
        val entries = listOf(
            Entry(0f, 450f), // Monday
            Entry(1f, 520f), // Tuesday
            Entry(2f, 380f), // Wednesday
            Entry(3f, 490f), // Thursday
            Entry(4f, 600f), // Friday (current day)
            Entry(5f, 0f),   // Saturday (future)
            Entry(6f, 0f)    // Sunday (future)
        )

        val dataSet = LineDataSet(entries, "Calories").apply {
            color = Color.WHITE
            lineWidth = 3f
            setDrawCircles(false)
            setDrawValues(false)
            mode = LineDataSet.Mode.CUBIC_BEZIER
            cubicIntensity = 0.2f
            setDrawFilled(true)
            fillColor = Color.parseColor("#40FFFFFF")
        }

        val lineData = LineData(dataSet)
        calorieChart.apply {
            data = lineData
            description.isEnabled = false
            legend.isEnabled = false
            setTouchEnabled(false)
            isDragEnabled = false
            setScaleEnabled(false)
            setPinchZoom(false)

            // Hide axes
            xAxis.isEnabled = false
            axisLeft.isEnabled = false
            axisRight.isEnabled = false

            // Remove grid lines
            setDrawGridBackground(false)
            xAxis.setDrawGridLines(false)
            axisLeft.setDrawGridLines(false)
            axisRight.setDrawGridLines(false)

            invalidate()
        }
    }

    private fun setupClickListeners() {
        profileImage.setOnClickListener {
            Toast.makeText(this, "Profile clicked", Toast.LENGTH_SHORT).show()
            // TODO: Navigate to profile activity
        }

        searchIcon.setOnClickListener {
            Toast.makeText(this, "Search clicked", Toast.LENGTH_SHORT).show()
            // TODO: Open search functionality
        }

        menuIcon.setOnClickListener {
            Toast.makeText(this, "Menu clicked", Toast.LENGTH_SHORT).show()
            // TODO: Open navigation drawer or menu
        }

        scheduleMenuIcon.setOnClickListener {
            Toast.makeText(this, "Schedule options clicked", Toast.LENGTH_SHORT).show()
            // TODO: Show schedule options menu
        }

        startWarmupButton.setOnClickListener {
            startWarmupActivity()
        }

        gridNavIcon.setOnClickListener {
            Toast.makeText(this, "Grid navigation clicked", Toast.LENGTH_SHORT).show()
            // TODO: Show grid view or navigate to apps grid
        }
    }

    private fun startWarmupActivity() {
        // Update button state
        startWarmupButton.text = "Starting..."
        startWarmupButton.isEnabled = false

        Toast.makeText(this, "Starting WarmUp activity...", Toast.LENGTH_SHORT).show()

        // Simulate starting activity delay
        startWarmupButton.postDelayed({
            startWarmupButton.text = "Start"
            startWarmupButton.isEnabled = true
            // TODO: Start workout activity
            // val intent = Intent(this, WorkoutActivity::class.java)
            // startActivity(intent)
        }, 2000)
    }

    override fun onResume() {
        super.onResume()
        setupGreeting() // Update greeting based on current time
        updateCalorieData() // Refresh calorie data if needed
    }

    private fun updateCalorieData() {
        // This method can be called to update calorie data from your data source
        // For example, from SharedPreferences, database, or API

        // Sample implementation:
        // val todayCalories = getCaloriesFromDataSource()
        // calorieCount.text = "${todayCalories}cal"
    }

    // Helper method to get current day of week for highlighting
    private fun getCurrentDayOfWeek(): Int {
        val calendar = Calendar.getInstance()
        val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)
        // Convert to Monday = 0, Sunday = 6
        return (dayOfWeek + 5) % 7
    }
}