package com.example.dietrecord.diary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.Spinner
import androidx.fragment.app.Fragment
import com.example.dietrecord.R
import com.example.dietrecord.menu.frag_diary
import kotlinx.android.synthetic.main.diary_graph.*

class frag_diary_graph: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//  main이랑 연결

        val view = inflater.inflate(R.layout.diary_graph, container, false)
        val diary_btn = view.findViewById<ImageButton>(R.id.back_to_diary_btn)
        val spinner = view.findViewById<Spinner>(R.id.diary_graph_spinner)
        var list_of_items = resources.getStringArray(R.array.diary_graph_spinner_menu)
        spinner.adapter = this.activity?.let { ArrayAdapter(it, android.R.layout.simple_dropdown_item_1line, list_of_items) }


        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                when (position){
//                    0-> {
//                        diary_graph_total_kcal.text = "10000"
//                    }
                    0->{
                        diary_graph_total_kcal.text = "10000"
                        diary_graph_day_kcal.text = "일일평균:5634"
                        diary_graph_target_kcal.text ="목표:3241kcal"
                    }
                    1->{
                        diary_graph_total_kcal.text = "30000"
                        diary_graph_day_kcal.text = "일일평균:9876"
                        diary_graph_target_kcal.text ="목표:4321kcal"
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        diary_btn.setOnClickListener {
            val ft = this.activity?.supportFragmentManager?.beginTransaction()
            ft?.replace(R.id.main_frag, frag_diary())?.commit()
        }
        return view
    }
}