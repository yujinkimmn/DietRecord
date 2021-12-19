package com.example.dietrecord.food

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dietrecord.databinding.FoodDetailBinding

class frag_detail : Fragment() {
    private var mbinding: FoodDetailBinding? = null
    private val binding get() = mbinding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mbinding = FoodDetailBinding.inflate(inflater, container, false)
        return binding.root
    }
}
