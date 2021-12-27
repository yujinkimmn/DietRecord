package com.example.dietrecord.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dietrecord.R
import com.example.dietrecord.databinding.ActivitySub2Binding
import com.example.dietrecord.databinding.ActivitySub3Binding
import kotlinx.android.synthetic.main.activity_sub3.*

class Sub3Activity : AppCompatActivity() {

    private var mbinding: ActivitySub3Binding? = null
    private val binding get() = mbinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mbinding = ActivitySub3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        if (intent.hasExtra("name"))
        {
            val username = intent.getStringExtra("name")
            binding.tvWel.setText("안녕하세요, $username 님!")
            binding.tvQues.setText(("$username 님의 목표는 무엇인가요?"))

            var intent = Intent(this, Sub4Activity::class.java)
            intent.putExtra("name", username)

            binding.rgAct.setOnCheckedChangeListener{ group, checkedId ->
                when(checkedId){
                    R.id.btn_low -> intent.putExtra("goal", "체중 감소")
                    R.id.btn_md -> intent.putExtra("goal", "체중 유지")
                    R.id.btn_high -> intent.putExtra("goal", "체중 증가")
                }
            }
            binding.btnNext.setOnClickListener {
                startActivity(intent)
            }
        }
    }
}