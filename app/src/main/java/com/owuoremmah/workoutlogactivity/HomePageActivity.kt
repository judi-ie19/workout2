package com.owuoremmah.workoutlogactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.owuoremmah.workoutlogactivity.databinding.ActivityHomePageBinding
import com.owuoremmah.workoutlogactivity.databinding.ActivitySignupBinding

class HomePageActivity : AppCompatActivity() {
   lateinit var binding: ActivityHomePageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        castViews()
        setBottomNav()
    }

    fun castViews() {
//        binding.bottomNavigation = findViewById(R.id.bottom_navigation)
//        fcvHome = findViewById(R.id.fcvHome)

    }

    fun setBottomNav() {

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.Plan -> {
                    val transaction = supportFragmentManager.beginTransaction()
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