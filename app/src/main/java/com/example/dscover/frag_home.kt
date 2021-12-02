package com.example.dscover

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class frag_home : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//  main이랑 연결

        val view = inflater.inflate(R.layout.home, container, false)

        return view
    }
}