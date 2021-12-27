package com.example.dietrecord.menu
import android.app.AlertDialog
import android.content.Context

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dietrecord.R
import com.example.dietrecord.databinding.DiaryBinding
import com.example.dietrecord.diary.Diary
import com.example.dietrecord.diary.DiaryAdapter
import com.example.dietrecord.diary.frag_diary_graph
import java.io.*
import java.util.*


class frag_diary: Fragment() {
    private lateinit var fname: String
    var diaryList = arrayListOf<Diary>()


    private var mBinding: DiaryBinding? = null
    private val binding get() = mBinding!!
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//  main이랑 연결
        val instance = Calendar.getInstance()
        var tyear = instance.get(Calendar.YEAR)
        var tmonth = instance.get(Calendar.MONTH)
        var tday = instance.get(Calendar.DATE)

        mBinding = DiaryBinding.inflate(inflater, container, false)

        diaryList = arrayListOf<Diary>() //리스트 초기화
        checkDay(tyear, tmonth, tday)
        mBinding!!.rvDiary.layoutManager = LinearLayoutManager(this.activity, LinearLayoutManager.VERTICAL, false)
        mBinding!!.rvDiary.adapter = DiaryAdapter(diaryList)

        mBinding!!.graphBtn.setOnClickListener { //그래프로 넘어감
            val ft = this.activity?.supportFragmentManager?.beginTransaction()
            ft?.replace(R.id.main_frag, frag_diary_graph())?.commit()
//            frag_diary().onDestroyView() //oncreateview 초기화
        }

        mBinding!!.calendarView.setOnDateChangeListener { view, year, month, dayOfMonth -> //달력 누를때마다 작동
            diaryList = arrayListOf<Diary>() //리스트 초기화
            checkDay(year, month, dayOfMonth)

            tyear = year
            tmonth = month
            tday = dayOfMonth
//            val test2 = year.toString() + month.toString() + dayOfMonth.toString()
//            Toast.makeText(activity, test2, Toast.LENGTH_SHORT).show()
            mBinding!!.rvDiary.layoutManager = LinearLayoutManager(this.activity, LinearLayoutManager.VERTICAL, false)
            mBinding!!.rvDiary.adapter = DiaryAdapter(diaryList)
        }

//        mBinding!!.rvDiary.layoutManager = LinearLayoutManager(this.activity, LinearLayoutManager.VERTICAL, false)
//        mBinding!!.rvDiary.adapter = DiaryAdapter(diaryList)
        mBinding!!.diaryBtn.setOnClickListener {
            val mDialogView = LayoutInflater.from(requireContext()).inflate(R.layout.alert_dialog, null)
            val mBuilder = AlertDialog.Builder(requireContext())
                .setView(mDialogView)

            val mAlertDialog = mBuilder.show()
            val save_btn = mDialogView.findViewById<Button>(R.id.diary_save_btn)
            val cancel_btn = mDialogView.findViewById<Button>(R.id.diary_cancel_btn)
            var edittxt = mDialogView.findViewById<EditText>(R.id.diary_text)

            save_btn.setOnClickListener {
                val content = edittxt.text.toString() + "\n"
//                Toast.makeText(activity, fname, Toast.LENGTH_SHORT).show()
//                Toast.makeText(activity, "message", Toast.LENGTH_SHORT).show()
                saveDiary(fname, content)
                diaryList.add(0, Diary(edittxt.text.toString()))
                mBinding!!.rvDiary.layoutManager = LinearLayoutManager(this.activity, LinearLayoutManager.VERTICAL, false)
                mBinding!!.rvDiary.adapter = DiaryAdapter(diaryList)
                mAlertDialog.dismiss()
            }
            cancel_btn.setOnClickListener {
                mAlertDialog.dismiss()
            }
        }
//        return view
        return binding.root
    }

    fun checkDay(cYear: Int, cMonth: Int, cDay: Int){
        fname = String.format("%d-%d-%d", cYear, cMonth, cDay)

        var fileInputStream: FileInputStream
        try {
            fileInputStream = requireContext().openFileInput(fname)
            val fileData = ByteArray(fileInputStream.available())
            fileInputStream.read(fileData)
//            Toast.makeText(activity, String(fileData, charset("UTF-8")), Toast.LENGTH_SHORT).show()
            var data = String(fileData, charset("UTF-8"))
            data.reader().readLines().forEach {
                diaryList.add(0, Diary(it))
            }
            fileInputStream.close()
        }
        catch (e: Exception){
            e.printStackTrace()
        }
    }

    fun saveDiary(readDay: String?, texts: String){

        val fileOutputStream: FileOutputStream


        try{
            fileOutputStream = requireContext().openFileOutput(readDay, Context.MODE_APPEND)
            fileOutputStream.write(texts.toByteArray(Charsets.UTF_8))
            fileOutputStream.close()

        }
        catch (e: FileNotFoundException){
            e.printStackTrace()
        }catch (e: NumberFormatException){
            e.printStackTrace()
        }catch (e: IOException){
            e.printStackTrace()
        } catch (e: Exception){
            e.printStackTrace()
        }
    }
    override fun onDestroyView() {
    // onDestroyView 에서 binding class 인스턴스 참조를 정리해주어야 한다.
    mBinding = null
    super.onDestroyView()
    }
}