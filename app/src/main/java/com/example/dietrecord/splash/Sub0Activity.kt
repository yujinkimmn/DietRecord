package com.example.dietrecord.splash

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.dietrecord.R
import com.example.dietrecord.databinding.ActivitySub0Binding
import kotlinx.android.synthetic.main.activity_main.*

class Sub0Activity : AppCompatActivity() {

    private var mbinding: ActivitySub0Binding? = null
    private val binding get() = mbinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mbinding = ActivitySub0Binding.inflate(layoutInflater)
        setContentView(binding.root)

//        setContentView(R.layout.activity_sub0)

        binding.btnStart.setOnClickListener {
            Toast.makeText(this, "시작하기", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Sub1Activity::class.java)
            startActivity(intent)
        }
    }
}