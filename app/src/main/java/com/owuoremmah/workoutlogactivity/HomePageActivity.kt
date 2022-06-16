package com.owuoremmah.workoutlogactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomePageActivity : AppCompatActivity() {
    lateinit var bottom_navigation: BottomNavigationView
    lateinit var fcvHome: FragmentContainerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
        castViews()
        setBottomNav()
    }

    fun castViews() {
        bottom_navigation = findViewById(R.id.bottom_navigation)
        fcvHome = findViewById(R.id.fcvHome)

    }

    fun setBottomNav() {

        bottom_navigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.Plan -> {
                    var transaction = supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.fcvHome, PlanFragment())
                    transaction.commit()
                    true

                }


                R.id.Track -> {
                    val transaction = supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.fcvHome, Trackfragment())
                    transaction.commit()
                    true

                }

                R.id.Profile -> {
                    val transaction = supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.fcvHome, ProfileFragment())
                    transaction.commit()
                    true

                }
                else -> false
            }


        }

    }
}