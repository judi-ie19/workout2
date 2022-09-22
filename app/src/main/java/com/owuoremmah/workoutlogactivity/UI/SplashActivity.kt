package com.owuoremmah.workoutlogactivity.UI

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashActivity : AppCompatActivity() {
    lateinit var sharedPrefs:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPrefs=getSharedPreferences("WORKOprofileIdUT_PREFS", MODE_PRIVATE)

        val accessToken=sharedPrefs.getString("ACCESS_TOKEN","")
        if (accessToken!!.isBlank()){
            startActivity(Intent(this, loginActivity::class.java))

        }
        startActivity(Intent(this, HomePageActivity::class.java))

    }
}
