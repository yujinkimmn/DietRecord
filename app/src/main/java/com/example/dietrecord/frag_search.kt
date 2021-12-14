package com.example.dietrecord

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dietrecord.databinding.HomeBinding
import com.example.dietrecord.databinding.SearchBinding
import kotlinx.android.synthetic.main.search.*

class frag_search : Fragment(){

    private var mbinding: SearchBinding? = null
    private val binding get() = mbinding!!

    private var meal: String? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mbinding = SearchBinding.inflate(inflater, container, false)

        arguments?.let{
            meal = it.getString("mealtitle")
        }

        binding.tvFragSearchMealTitle.setText(meal)
        binding.btnFragSearchClose.setOnClickListener {
            val mActivity = activity as MainActivity
            mActivity.setFragment(TAG_HOME_FRAGMENT, frag_home())
            //fragmentManager?.beginTransaction()?.remove(this)?.commit()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mbinding = null
    }

}