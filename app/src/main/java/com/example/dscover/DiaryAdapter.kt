package com.example.dscover

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DiaryAdapter(val diaryList: ArrayList<Diary>) : RecyclerView.Adapter<DiaryAdapter.CustomViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiaryAdapter.CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.diary_rcview, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: DiaryAdapter.CustomViewHolder, position: Int) {
        holder.dtext.text = diaryList.get(position).dtext
    }

    override fun getItemCount(): Int {
        return diaryList.size
    }

    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dtext = itemView.findViewById<TextView>(R.id.diary_text)
    }

}