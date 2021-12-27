package com.example.dietrecord.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dietrecord.R
import com.example.dietrecord.databinding.ActivitySub1Binding

class Sub1Activity : AppCompatActivity() {

    private var mbinding: ActivitySub1Binding? = null
    private val binding get() = mbinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_sub1)

        mbinding = ActivitySub1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNext.setOnClickListener{
            val intent = Intent(this,Sub2Activity::class.java)
            startActivity(intent)
        }
    }
}