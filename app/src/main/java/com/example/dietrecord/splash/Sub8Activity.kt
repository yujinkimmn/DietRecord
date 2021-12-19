package com.example.dietrecord.splash


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.dietrecord.MainActivity
import com.example.dietrecord.*
import com.example.dietrecord.TAG_MYPAGE_FRAGMENT
import com.example.dietrecord.databinding.ActivitySub2Binding
import com.example.dietrecord.databinding.ActivitySub8Binding
import com.example.dietrecord.menu.frag_profile
import kotlinx.android.synthetic.main.activity_sub8.*
import kotlinx.android.synthetic.main.activity_sub8.btn_next
import java.util.*

class Sub8Activity : AppCompatActivity() {

    private var mbinding: ActivitySub8Binding? = null
    private val binding get() = mbinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mbinding = ActivitySub8Binding.inflate(layoutInflater)
        setContentView(binding.root)

        if (intent.hasExtra("name"))
        {
            val username = intent.getStringExtra("name")
            val goal = intent.getStringExtra("goal")
            val sex = intent.getStringExtra("sex")
            val act = intent.getStringExtra("activity")
            val wgt = intent.getStringExtra("weight")
            val hgt = intent.getStringExtra("height")

            binding.tvQues.setText(("$username 님의 생일은 언제인가요?"))

            binding.btnNext.setOnClickListener {

                val day = dp_birth.dayOfMonth
                val month = dp_birth.month + 1
                val year = dp_birth.year
                val cal = Calendar.getInstance()
                val currYear = cal.get(Calendar.YEAR)
                var intent = Intent(this, MainActivity::class.java)

                intent.putExtra("name", username)
                intent.putExtra("goal", goal)
                intent.putExtra("sex", sex)
                intent.putExtra("activity", act)
                intent.putExtra("weight", wgt)
                intent.putExtra("height", hgt)
                intent.putExtra("birth", "${year}년 ${month}월 ${day}일")
                intent.putExtra("age", (currYear.toInt() - year.toInt() + 1).toString())

                // Profile 클래스로 선언
                var profileData = Profile(username, goal, sex, act, wgt, hgt,
                    "${year}년 ${month}월 ${day}일",
                    (currYear.toInt() - year.toInt() + 1).toString())

                // MainActivity로 값 넘기고 실행
                startActivity(intent)
//                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//                startActivity(intent)
//                Toast.makeText(this@Sub8Activity, "정보 등록이 완료되었습니다", Toast.LENGTH_SHORT).show()
            }
        }
    }
}