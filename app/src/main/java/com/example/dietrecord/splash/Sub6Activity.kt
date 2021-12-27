package com.example.dietrecord.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dietrecord.R
import com.example.dietrecord.databinding.ActivitySub2Binding
import com.example.dietrecord.databinding.ActivitySub6Binding
import kotlinx.android.synthetic.main.activity_sub6.*
class Sub6Activity : AppCompatActivity() {

    private var mbinding: ActivitySub6Binding? = null
    private val binding get() = mbinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mbinding = ActivitySub6Binding.inflate(layoutInflater)
        setContentView(binding.root)

        if (intent.hasExtra("name"))
        {
            val username = intent.getStringExtra("name")
            val goal = intent.getStringExtra("goal")
            val sex = intent.getStringExtra("sex")
            val act = intent.getStringExtra("activity")

            binding.tvQues.setText(("$username 님의 현재 체중은 얼마인가요?"))

            binding.btnNext.setOnClickListener {
                var intent = Intent(this, Sub7Activity::class.java)
                intent.putExtra("name", username)
                intent.putExtra("goal", goal)
                intent.putExtra("sex", sex)
                intent.putExtra("activity", act)
                intent.putExtra("weight", et_wgt.text.toString())

                startActivity(intent)
            }
        }
    }
}