package com.owuoremmah.workoutlogactivity.UI

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.owuoremmah.workoutlogactivity.API.APiClient
import com.owuoremmah.workoutlogactivity.API.ApiInterface
import com.owuoremmah.workoutlogactivity.databinding.ActivityLogin2Binding
import com.owuoremmah.workoutlogactivity.models.LoginResponse
import com.owuoremmah.workoutlogactivity.models.LoginRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class loginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLogin2Binding
    lateinit var sharedPrefs:SharedPreferences


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
            binding.pblogin.visibility=View.GONE
            makeloginrequest(loginrequest)



        }
    }
        fun makeloginrequest(loginRequest: LoginRequest) {
            val apiClient = APiClient.buildApiClient(ApiInterface::class.java)
            val request = apiClient.loginUser(loginRequest)

            request.enqueue(object : Callback<LoginResponse> {
                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    binding.pblogin.visibility=View.GONE
                    if (response.isSuccessful) {
                        val loginResponse=response.body()
                        Toast.makeText(baseContext, response.body()?.message, Toast.LENGTH_LONG).show()
                        saveLoginDetails(loginResponse!!)
                        startActivity(Intent(baseContext,HomePageActivity::class.java))


                    }
                    else{
                        val error=response.errorBody()?.string()
                        Toast.makeText(baseContext,response.body()?.message,Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()

                }


            })
        }
    fun saveLoginDetails(loginResponse: LoginResponse){
        val editor=sharedPrefs.edit()
        editor.putString("ACCESS_TOKEN",loginResponse.accessToken)
        editor.putString("USER_ID",loginResponse.userId)
        editor.putString("PROFILE_ID",loginResponse.profileId)


    }
    }
