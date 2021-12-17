package com.example.dietrecord.food

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dietrecord.MainActivity
import com.example.dietrecord.R
import com.example.dietrecord.TAG_HOME_FRAGMENT
import com.example.dietrecord.databinding.SearchBinding
import com.example.dietrecord.menu.frag_home
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.food.view.*

class frag_search : Fragment(){

    private var mbinding: SearchBinding? = null
    private val binding get() = mbinding!!
    private var meal: String? = null
    private var firestore : FirebaseFirestore?= null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mbinding = SearchBinding.inflate(inflater, container, false)
        arguments?.let{
            meal = it.getString("mealtitle")
        }
        binding.tvFragSearchMealTitle.setText(meal)

        // 닫기 버튼
        binding.btnFragSearchClose.setOnClickListener {
            val mActivity = activity as MainActivity
            mActivity.setFragment(TAG_HOME_FRAGMENT, frag_home())
            fragmentManager?.beginTransaction()?.remove(this)?.commit()
        }
        // 파이어스토어 인스턴스 초기화
        firestore = FirebaseFirestore.getInstance()

        binding.rvFragSearch.adapter = RecyclerViewAdapter()
        //binding.rvFragSearch.layoutManager = LinearLayoutManager(this)

        // 검색
        binding.btnFragSearch.setOnClickListener {
            (binding.rvFragSearch.adapter as RecyclerViewAdapter).searchFood(binding.etFragSearch.text.toString())
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mbinding = null
    }


    inner class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
        // Food 클래스 ArrayList 생성
        var foodList: ArrayList<Food> = arrayListOf()

        init{ // 데이터 불러온 뒤 Food로 변환 후 ArrayList에 담기
            firestore?.collection("nutrients")?.addSnapshotListener { querySnapshot, firebaseFirestoreException ->
                foodList.clear()

                for (snapshot in querySnapshot!!.documents){
                    var foodItem = snapshot.toObject(Food::class.java)
                }
                notifyDataSetChanged()
            }
        }

        // xml 파일 inflate해서 viewholder 생성
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            var view = LayoutInflater.from(parent.context).inflate(R.layout.food, parent, false)
            return ViewHolder(view)
        }

        inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        }

        // onCreateViewHolder에서 만든 view와 실제 데이터를 연결
        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            var viewHolder = (holder as ViewHolder).itemView
            viewHolder.tv_food_name.text = foodList[position].name
            viewHolder.tv_food_gram.text = foodList[position].gram
            viewHolder.tv_frag_food_calorie.text = foodList[position].calorie
        }

        override fun getItemCount(): Int {
            return foodList.size
        }

        // 파이어스토어에서 음식 검색하기 함수
        fun searchFood(searchWord: String){
            firestore?.collection("nutrients")?.addSnapshotListener { querySnapshot, firebaseFirestoreException ->

                // ArrayList 비우기
                foodList.clear()

                for (snapshot in querySnapshot!!.documents){
                    if(snapshot.contains(searchWord)){
                        var item = snapshot.toObject(Food::class.java)
                        foodList.add(item!!)
                    }
                }
                notifyDataSetChanged()
            }
        }
    }

}