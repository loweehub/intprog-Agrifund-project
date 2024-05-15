package com.crowdfunding.agri_fund

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val regs = findViewById<Button>(R.id.register)
        val logBtn = findViewById<Button>(R.id.log_in)

        logBtn.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

        regs.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }
        }
    }


