package com.example.dietrecord.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dietrecord.R
import com.example.dietrecord.databinding.ActivitySub1Binding
import com.example.dietrecord.databinding.ActivitySub2Binding
import kotlinx.android.synthetic.main.activity_sub2.*

class Sub2Activity : AppCompatActivity() {

    private var mbinding: ActivitySub2Binding? = null
    private val binding get() = mbinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mbinding = ActivitySub2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        btn_next.setOnClickListener {
            val intent = Intent(this, Sub3Activity::class.java)

            intent.putExtra("name", binding.etName.text.toString())
            startActivity(intent)
        }
    }
}