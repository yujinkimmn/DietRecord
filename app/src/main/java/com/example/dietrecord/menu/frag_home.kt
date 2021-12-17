package com.example.dietrecord.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dietrecord.MainActivity
import com.example.dietrecord.R
import com.example.dietrecord.databinding.HomeBinding
import com.example.dietrecord.food.frag_search


class frag_home : Fragment(), View.OnClickListener {

    private var mBinding: HomeBinding? = null
    private val binding get() = mBinding!!
    private var waterLiter : Double?= 0.0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        mBinding = HomeBinding.inflate(inflater, container, false)


//        // 파이 차트 설정
//        val piechart = frag_home_piechart
//        piechart.setUsePercentValues(true)
//        // data
//        val piedata = ArrayList<PieEntry>()
//        piedata.add(PieEntry(1580f))
//
//        val colorItems = ArrayList<String>()
//        colorItems.add("F8DA78")
//
//        val pieDataSet = PieDataSet(piedata, "")
//        pieDataSet.apply {
//            color = colorItems
//
//        }

        /* 음식 추가 버튼 눌렀을 때 프래그먼트 전환 */
        binding.btnFragHomeBreakfast.setOnClickListener {
            val mActivity = activity as MainActivity
            mActivity.setDataAtFragment(frag_search(), "아침 식사")
        }

        binding.btnFragHomeLunch.setOnClickListener {
            val mActivity = activity as MainActivity
            mActivity.setDataAtFragment(frag_search(), "점심 식사")
        }

        binding.btnFragHomeDinner.setOnClickListener {
            val mActivity = activity as MainActivity
            mActivity.setDataAtFragment(frag_search(), "저녁 식사")
        }

        binding.btnFragHomeSnack.setOnClickListener {
            val mActivity = activity as MainActivity
            mActivity.setDataAtFragment(frag_search(), "간식")
        }

        /* 물 컵 눌렀을 때 */
        binding.ivCup1.setOnClickListener(this)
        binding.ivCup2.setOnClickListener(this)
        binding.ivCup3.setOnClickListener(this)
        binding.ivCup4.setOnClickListener(this)
        binding.ivCup5.setOnClickListener(this)
        binding.ivCup6.setOnClickListener(this)
        binding.ivCup7.setOnClickListener(this)
        binding.ivCup8.setOnClickListener(this)
        binding.ivCup9.setOnClickListener(this)
        binding.ivCup10.setOnClickListener(this)

        return binding.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }

    override fun onClick(v: View?) {
        // 컵 하나 누를 때 마다 0.25리터씩 추가
        waterLiter = waterLiter?.plus(0.25)
        binding.tvFragHomeLiter.setText(waterLiter.toString() + "리터")
        when(v?.id){
            binding.ivCup1.id -> binding.ivCup1.setImageResource(R.drawable.btn_glass_of_water_full)
            binding.ivCup2.id -> binding.ivCup2.setImageResource(R.drawable.btn_glass_of_water_full)
            binding.ivCup3.id -> binding.ivCup3.setImageResource(R.drawable.btn_glass_of_water_full)
            binding.ivCup4.id -> binding.ivCup4.setImageResource(R.drawable.btn_glass_of_water_full)
            binding.ivCup5.id -> binding.ivCup5.setImageResource(R.drawable.btn_glass_of_water_full)
            binding.ivCup6.id -> binding.ivCup6.setImageResource(R.drawable.btn_glass_of_water_full)
            binding.ivCup7.id -> binding.ivCup7.setImageResource(R.drawable.btn_glass_of_water_full)
            binding.ivCup8.id -> binding.ivCup8.setImageResource(R.drawable.btn_glass_of_water_full)
            binding.ivCup9.id -> binding.ivCup9.setImageResource(R.drawable.btn_glass_of_water_full)
            binding.ivCup10.id -> binding.ivCup10.setImageResource(R.drawable.btn_glass_of_water_full)
        }
    }


}