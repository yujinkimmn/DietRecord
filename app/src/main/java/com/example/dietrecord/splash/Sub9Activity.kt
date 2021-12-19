package com.example.dietrecord.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dietrecord.R
import com.example.dietrecord.databinding.ActivitySub2Binding
import com.example.dietrecord.databinding.ActivitySub9Binding
import kotlinx.android.synthetic.main.activity_sub9.*

class Sub9Activity : AppCompatActivity() {

    private var mbinding: ActivitySub9Binding? = null
    private val binding get() = mbinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mbinding = ActivitySub9Binding.inflate(layoutInflater)
        setContentView(binding.root)

        if (intent.hasExtra("name")) {
            var username = intent.getStringExtra("name")
            var goal = intent.getStringExtra("goal")
            var sex = intent.getStringExtra("sex")
            var act = intent.getStringExtra("activity")
            var wgt = intent.getStringExtra("weight")
            var hgt = intent.getStringExtra("height")
            var birth = intent.getStringExtra("birth")
            var age = intent.getStringExtra("age")
            var water = 8
            var walk = 6000
            var kcal = when(act) {
                "낮은 활동적" -> ((hgt?.toInt() ?: 165) - 100) * 0.9 * 25
                "활동적" -> ((hgt?.toInt() ?: 165) - 100) * 0.9 * 35
                "매우 활동적" -> ((hgt?.toInt() ?: 165) - 100) * 0.9 * 45
                else -> ((hgt?.toInt() ?: 165) - 100) * 0.9 * 35
            }
            binding.tvName.text = ("$username 님")
            binding.tvBirth.text = birth
            binding.tvSex.text = ("성별: ${sex}")
            binding.tvAge.text = ("나이: ${age}")
            binding.tvHgt.text = ("키: ${hgt}cm")
            binding.tvWgt.text = ("몸무게: ${wgt}kg")
            binding.tvAct.text = ("활동지수: ${act}")
            binding.tvGoal.text = ("목표: ${goal}")
            binding.tvKcal.text = ("섭취 칼로리: ${kcal}kcal")
            binding.tvWater.text = ("물: ${water}잔")
            binding.tvWalk.text = ("걸음: ${walk}보")
        }
    }
}