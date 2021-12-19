package com.example.dietrecord.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dietrecord.R
import com.example.dietrecord.databinding.ActivitySub2Binding
import com.example.dietrecord.databinding.ActivitySub5Binding
import kotlinx.android.synthetic.main.activity_sub5.*

class Sub5Activity : AppCompatActivity() {

    private var mbinding: ActivitySub5Binding? = null
    private val binding get() = mbinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mbinding = ActivitySub5Binding.inflate(layoutInflater)
        setContentView(binding.root)

//        setContentView(R.layout.activity_sub5)

        if (intent.hasExtra("name"))
        {
            val username = intent.getStringExtra("name")
            val goal = intent.getStringExtra("goal")
            val sex = intent.getStringExtra("sex")
            binding.tvQues.setText(("$username 님의 활동 수준은 어느 정도인가요?"))

            var intent = Intent(this, Sub6Activity::class.java)
            intent.putExtra("name", username)
            intent.putExtra("goal", goal)
            intent.putExtra("sex", sex)

            rg_act.setOnCheckedChangeListener{ group, checkedId ->
                when(checkedId){
                    R.id.btn_low -> intent.putExtra("activity", "낮은 활동적")
                    R.id.btn_md -> intent.putExtra("activity", "활동적")
                    R.id.btn_high -> intent.putExtra("activity", "매우 활동적")
                }
            }
            binding.btnNext.setOnClickListener {
                startActivity(intent)
            }
        }
    }
}