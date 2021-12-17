package com.example.dietrecord.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dietrecord.R

class frag_profile: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//  main이랑 연결

        val view = inflater.inflate(R.layout.profile, container, false)

        return view
    }
}