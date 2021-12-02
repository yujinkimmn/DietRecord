package com.example.dietrecord

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*


// commit 하기
class MainActivity : AppCompatActivity() {
    private val frag_diary by lazy { frag_diary() }
    private val frag_home by lazy { frag_home() }
    private val frag_profile by lazy { frag_profile() }


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
                        changeFragment(frag_diary) }
                    R.id.ic_home -> {
                        changeFragment(frag_home) }
                    R.id.ic_profile -> {
                        changeFragment(frag_profile)
                    }
                }
                true
            }
            selectedItemId = R.id.ic_home
        }
    }

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_frag, fragment)
            .commit()
    }
}
