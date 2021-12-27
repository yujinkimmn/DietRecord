package com.example.dietrecord.diary

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dietrecord.R
import com.example.dietrecord.databinding.DiaryRcviewSavedBinding

class DiaryAdapter(val diaryList: ArrayList<Diary>) : RecyclerView.Adapter<DiaryAdapter.CustomViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.diary_rcview_saved, parent, false)
//        return CustomViewHolder(view)
        val view = LayoutInflater.from(parent.context).inflate(R.layout.diary_rcview_saved, parent, false)
        return CustomViewHolder(DiaryRcviewSavedBinding.bind(view))
//        val binding = bindViewHolder
//        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: CustomViewHolder, position: Int){
//                (holder: DiaryAdapter.CustomViewHolder, position: Int) {
        viewHolder.binding.diarySavedText.text = diaryList.get(position).dtext
    }

    override fun getItemCount(): Int {
        return diaryList.size
    }

    class CustomViewHolder(val binding: DiaryRcviewSavedBinding):
        RecyclerView.ViewHolder(binding.root)
//        (itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val dtext = itemView.findViewById<TextView>(R.id.diary_saved_text)

}
