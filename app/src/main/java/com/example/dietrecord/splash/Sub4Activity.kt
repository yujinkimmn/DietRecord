package com.example.dietrecord.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dietrecord.R
import com.example.dietrecord.databinding.ActivitySub2Binding
import com.example.dietrecord.databinding.ActivitySub4Binding
import kotlinx.android.synthetic.main.activity_sub4.*

class Sub4Activity : AppCompatActivity() {

    private var mbinding: ActivitySub4Binding? = null
    private val binding get() = mbinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_sub4)
        mbinding = ActivitySub4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        if (intent.hasExtra("name"))
        {
            val username = intent.getStringExtra("name")
            val goal = intent.getStringExtra("goal")
            binding.tvQues.setText(("$username 님의 성별은 무엇인가요?"))

            var intent = Intent(this, Sub5Activity::class.java)
            intent.putExtra("name", username)
            intent.putExtra("goal", goal)

            binding.rgSex.setOnCheckedChangeListener{ group, checkedId ->
                when(checkedId){
                    R.id.btn_female -> intent.putExtra("sex", "여성")
                    R.id.btn_male -> intent.putExtra("sex", "남성")
                }
            }
            binding.btnNext.setOnClickListener {
                startActivity(intent)
            }
        }
    }
}