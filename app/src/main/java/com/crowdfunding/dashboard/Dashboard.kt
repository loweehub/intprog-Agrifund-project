

package com.crowdfunding.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.crowdfunding.UserProfile.UserProfile
import com.crowdfunding.agri_fund.Login
import com.crowdfunding.agri_fund.R

class Dashboard : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        setupButtonClickListeners()
        setupDropdownSpinner()
    }

    private fun setupButtonClickListeners() {
        val buttons = mapOf(
            R.id.businessButton to Business::class.java,
            R.id.campaignButton to Campaign::class.java,
            R.id.progressButton to Progress::class.java,
            R.id.investButton to Invest::class.java,
            R.id.donateButton to Donation::class.java
        )

        buttons.forEach { (buttonId, activityClass) ->
            val button = findViewById<Button>(buttonId)
            button?.setOnClickListener {
                val intent = Intent(this, activityClass)
                startActivity(intent)
            }
        }
    }

    private fun setupDropdownSpinner() {
        val dropdownSpinner = findViewById<Spinner>(R.id.dropdownSpinner)
        val items = arrayOf("","Profile", "Logout")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items)
        dropdownSpinner.adapter = adapter

        dropdownSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                when (position) {
                    0 -> {}
                    1 -> navigateToUserProfile() // Profile
                    2 -> logoutUser() // Logout
                }
            }


            override fun onNothingSelected(parent: AdapterView<*>) {
                // Do nothing
            }
        }
    }

    private fun navigateToUserProfile() {
        val intent = Intent(this, UserProfile::class.java)
        startActivity(intent)
    }

    private fun logoutUser() {
        // Add your logout logic here
        // For example, clearing shared preferences and returning to login screen
        val sharedPreferences = getSharedPreferences("user_prefs", MODE_PRIVATE)
        sharedPreferences.edit().clear().apply()

        Toast.makeText(this, "Logged out", Toast.LENGTH_SHORT).show()

        val intent = Intent(this, Login::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }
}
