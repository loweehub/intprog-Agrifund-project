package com.crowdfunding.agri_fund
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import com.crowdfunding.dashboard.Dashboard


class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        Log.d("Login", "onCreate called")

        // Initialize views
        val emailEditText = findViewById<EditText>(R.id.emailLogin)
        val passwordEditText = findViewById<EditText>(R.id.passwordLogin)
        val loginButton = findViewById<Button>(R.id.logButton)

        // Set up login button click listener
        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (validateCredentials(email, password)) {
                Log.d("Login", "Credentials are valid")

                // Start Dashboard activity
                val intent = Intent(this, Dashboard::class.java)
                startActivity(intent)
                finish() // Close the Login activity
            } else {
                Log.d("Login", "Credentials are invalid")
                Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validateCredentials(email: String, password: String): Boolean {
        // Validate email
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return false
        }

        // Validate password
        val passwordRegex = Regex("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$")
        return passwordRegex.matches(password)

        // Additional validation logic, if needed

        // If all validations pass, return true
    }
}