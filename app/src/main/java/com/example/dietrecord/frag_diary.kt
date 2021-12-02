package com.example.dietrecord

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CalendarView
import androidx.fragment.app.Fragment

class frag_diary: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//  main이랑 연결

        val view = inflater.inflate(R.layout.diary, container, false)
        val calendarView = view.findViewById<CalendarView>(R.id.calendarView)
        val btn = view.findViewById<Button>(R.id.diary_btn)

        return view
    }
}