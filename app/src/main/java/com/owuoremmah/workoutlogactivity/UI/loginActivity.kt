package com.owuoremmah.workoutlogactivity.UI

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.owuoremmah.workoutlogactivity.models.UserViewModel
import com.owuoremmah.workoutlogactivity.databinding.ActivityLogin2Binding
import com.owuoremmah.workoutlogactivity.models.LoginResponse
import com.owuoremmah.workoutlogactivity.models.LoginRequest

class loginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLogin2Binding
    lateinit var sharedPrefs:SharedPreferences
    val userViewModel: UserViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogin2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPrefs=getSharedPreferences("WORKOprofileIdUT_PREFS",MODE_PRIVATE)


        binding.tvSignup.setOnClickListener {
            var intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
        binding.btnLogin.setOnClickListener {
            validatelogin()
            startActivity(Intent(this, HomePageActivity::class.java))

        }


    }

    override fun onResume() {
        super.onResume()
        userViewModel.loginResponseLiveData.observe(this, Observer { LoginResponse->
            Toast.makeText(baseContext, LoginResponse?.message, Toast.LENGTH_LONG).show()
            saveLoginDetails(LoginResponse!!)
            startActivity(Intent(baseContext,HomePageActivity::class.java))
        })

        userViewModel.errorLiveData.observe(this, Observer { error ->
            Toast.makeText(baseContext,error,Toast.LENGTH_LONG).show()
        })

    }

    fun validatelogin() {
        var error = false
        binding.tilEmail.error = null
        binding.tilEmail.error = null
        var email = binding.etEmail.text.toString()
        var password = binding.etPassword.text.toString()
        if (email.isBlank()) {
            binding.tilEmail.error = "email is required"
            error = true
        }
        if (password.isBlank()) {
            binding.tilPassword.error = "password is required"
            error = true
        }
        if (!error) {
            val loginrequest= LoginRequest(email, password)
            binding.pblogin.visibility=View.VISIBLE


        }
    }

    fun saveLoginDetails(loginResponse: LoginResponse){
        val editor=sharedPrefs.edit()
        editor.putString("ACCESS_TOKEN",loginResponse.accessToken)
        editor.putString("USER_ID",loginResponse.userId)
        editor.putString("PROFILE_ID",loginResponse.profileId)


    }
    }
