package com.example.dietrecord.food

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.dietrecord.MainActivity
import com.example.dietrecord.R
import com.example.dietrecord.TAG_SEARCH_FRAGMENT
import com.example.dietrecord.databinding.FoodDetailBinding
import kotlinx.android.synthetic.main.food_detail.*

class frag_detail : Fragment() {
    private var mbinding: FoodDetailBinding? = null
    private val binding get() = mbinding!!
    private var foodData: Food? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mbinding = FoodDetailBinding.inflate(inflater, container, false)

        // 선택한 음식 데이터 받아오기
        arguments?.let{
            foodData = it.getSerializable("foodData") as Food?
        }

        // 뷰 설정
        binding.tvFragFoodDetailFoodName.text = foodData?.foodName.toString()
        binding.tvFragFoodDetailGram.text = (foodData?.gram.toString() + "g")
        binding.tvFragFoodDetailCalorie.text = (foodData?.calorie.toString() + "Kcal\n칼로리")
        binding.tvFragFoodDetailCarbo.text = (foodData?.carbo.toString() + "g\n탄수화물")
        binding.tvFragFoodDetailFat.text = (foodData?.fat.toString() + "g\n지방")
        binding.tvFragFoodDetailProtein.text = (foodData?.protein.toString() + "g\n단백질")
        binding.tvFragFoodDetailSodium.text = (foodData?.sodium.toString() + "mg\n나트륨")

        // 뒤로가기 버튼(detail -> search로 이동)
        binding.btnFragDetailBack.setOnClickListener {
            val mActivity = activity as MainActivity
            mActivity.setFragment(TAG_SEARCH_FRAGMENT, frag_search())
            fragmentManager?.beginTransaction()?.remove(this)?.commit()

//            mActivity.changeDetailToSearch(frag_search())
        }

        // 클릭한 음식 home 프래그에 추가하기
        binding.btnFoodDetailAdd.setOnClickListener {

        }

        return binding.root
    }
}
