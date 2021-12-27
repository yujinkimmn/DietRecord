package com.example.dietrecord.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.example.dietrecord.R
import com.example.dietrecord.*
import com.example.dietrecord.databinding.ProfileBinding
import com.example.dietrecord.splash.Profile

class frag_profile: Fragment() {

    private var mbinding: ProfileBinding? = null
    private val binding get() = mbinding!!
    private var profileData: Profile? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): ConstraintLayout {
        mbinding = ProfileBinding.inflate(inflater, container, false)
//        val view = inflater.inflate(R.layout.profile, container, false)

        arguments?.let{
            profileData = it.getSerializable("profileData") as Profile?
        }
        if(profileData == null){
            Toast.makeText(context, "profileData == null", Toast.LENGTH_SHORT).show()
        }
        else{
            // 뷰 설정
            var kcal = when(profileData?.act) {
                "낮은 활동적" -> ((profileData!!.hgt?.toInt() ?: 165) - 100) * 0.9 * 25
                "활동적" -> ((profileData?.hgt?.toInt() ?: 165) - 100) * 0.9 * 35
                "매우 활동적" -> ((profileData?.hgt?.toInt() ?: 165) - 100) * 0.9 * 45
                else -> ((profileData?.hgt?.toInt() ?: 165) - 100) * 0.9 * 35
            }
            var water = 8
            var walk = 6000
            binding.tvName.text = ("${profileData?.userName.toString()} 님")
            binding.tvBirth.text = profileData?.birth.toString()
            binding.tvSex.text = ("성별: ${profileData?.sex.toString()}")
            binding.tvAge.text = ("나이: ${profileData?.age.toString()}")
            binding.tvHgt.text = ("키: ${profileData?.hgt.toString()}cm")
            binding.tvWgt.text = ("몸무게: ${profileData?.wgt.toString()}kg")
            binding.tvAct.text = ("활동지수: ${profileData?.act.toString()}")
            binding.tvGoal.text = ("목표: ${profileData?.goal.toString()}")
            binding.tvKcal.text = ("섭취 칼로리: ${kcal}kcal")
            binding.tvWater.text = ("물: ${water}잔")
            binding.tvWalk.text = ("걸음: ${walk}보")
        }

        return binding.root
    }
}