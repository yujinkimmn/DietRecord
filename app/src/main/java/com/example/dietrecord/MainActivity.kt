package com.example.dietrecord

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.dietrecord.menu.*
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*


const val TAG_HOME_FRAGMENT = "frag_home"
const val TAG_MYPAGE_FRAGMENT = "frag_profile"
const val TAG_DIARY_FRAGMENT = "frag_diary"
const val TAG_SEARCH_FRAGMENT = "frag_search"


class MainActivity : AppCompatActivity() {
    private val frag_diary by lazy { frag_diary() }
    private val frag_home by lazy { frag_home() }
    private val frag_profile by lazy { frag_profile() }
    //private val frag_search by lazy { frag_search() }
    var firestore : FirebaseFirestore? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initNavigationBar()

    }

    private fun initNavigationBar() {
        bottom_nav.run {
            setOnNavigationItemSelectedListener {
                when(it.itemId) {
                    R.id.ic_diary -> {
                       //changeFragment(frag_diary)
                        setFragment(TAG_DIARY_FRAGMENT, frag_diary) }
                    R.id.ic_home -> {
                        //changeFragment(frag_home)
                        setFragment(TAG_HOME_FRAGMENT, frag_home) }
                    R.id.ic_profile -> {
                        //changeFragment(frag_profile)
                        setFragment(TAG_MYPAGE_FRAGMENT, frag_profile)
                    }
                }
                true
            }
            selectedItemId = R.id.ic_home
        }
    }

    fun changeFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_frag, fragment)
            .commit()
    }

    /* Fragment State 유지 함수 */
    fun setFragment(tag: String, fragment: Fragment){
        val manager: FragmentManager = supportFragmentManager
        val ft: FragmentTransaction = manager.beginTransaction()

        if (manager.findFragmentByTag(tag) == null){
            ft.add(R.id.main_frag, fragment, tag)
        }

        val home = manager.findFragmentByTag(TAG_HOME_FRAGMENT)
        val mypage = manager.findFragmentByTag(TAG_MYPAGE_FRAGMENT)
        val diary = manager.findFragmentByTag(TAG_DIARY_FRAGMENT)
        val search = manager.findFragmentByTag(TAG_SEARCH_FRAGMENT)

        // 모든 fragment 숨기기
        if (home != null){
            ft.hide(home)
        }
        if (mypage != null){
            ft.hide(mypage)
        }
        if (diary != null){
            ft.hide(diary)
        }
        if (search != null){
            ft.hide(search)
        }

        // 현재 fragment 띄우기
        if (tag == TAG_HOME_FRAGMENT){
            if(home!=null){
                ft.show(home)
            }
        }
        if (tag == TAG_MYPAGE_FRAGMENT){
            if(mypage!=null){
                ft.show(mypage)
            }
        }
        if (tag == TAG_DIARY_FRAGMENT){
            if(diary!=null){
                ft.show(diary)
            }
        }
        if (tag == TAG_SEARCH_FRAGMENT){
            if(search!=null){
                ft.show(search)
            }
        }

        ft.commitAllowingStateLoss()
    }

    /* fragment간 데이터 전달 함수 */
    fun setDataAtFragment(fragment: Fragment, meal:String){
        val bundle = Bundle()
        bundle.putString("mealtitle", meal)
        fragment.arguments = bundle
        changeFragment(fragment)
    }
}
