package com.owuoremmah.workoutlogactivity.UI


import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.owuoremmah.workoutlogactivity.API.APiClient
import com.owuoremmah.workoutlogactivity.API.ApiInterface
import com.owuoremmah.workoutlogactivity.R

import com.owuoremmah.workoutlogactivity.models.RegisterRequest
import com.owuoremmah.workoutlogactivity.models.RegisterResponse
import com.owuoremmah.workoutlogactivity.models.UserViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignupActivity : AppCompatActivity() {
    lateinit var btnSignup:Button
    lateinit var tvLogin:TextView
    lateinit var etEmail:TextInputEditText
    lateinit var etFirstname:TextInputEditText
    lateinit var etLastName:TextInputEditText
    lateinit var etPassword:TextInputEditText
    lateinit var etConfirm:TextInputEditText
    lateinit var tilEmail:TextInputLayout
    lateinit var tilFirstname:TextInputLayout
    lateinit var tilLastName:TextInputLayout
    lateinit var tilPassword:TextInputLayout
    lateinit var tilConfirm:TextInputLayout

   lateinit var sharedPrefs:SharedPreferences
    val userViewModel:UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_signup)
        sharedPrefs=getSharedPreferences("WORKOprofileIdUT_PREFS",MODE_PRIVATE)
        
        
      tvLogin.setOnClickListener {
            val intent = Intent(this, loginActivity::class.java)
            startActivity(intent)
        }
    
       btnSignup.setOnClickListener {
            validatesignup()

        }
        
    }
    override fun onResume() {
        super.onResume()
        userViewModel.loginResponseLiveData.observe(this, Observer { RegisterResponse ->
            Toast.makeText(baseContext, RegisterResponse?.message, Toast.LENGTH_LONG).show()
//            (RegisterResponse!!)
            startActivity(Intent(baseContext, SignupActivity::class.java))
        })

        userViewModel.errorLiveData.observe(this, Observer { error ->
            Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
        })

    }
    
    fun validatesignup() {

       var firstname =etFirstname.text.toString()
        var lastname=etLastName.text.toString()
       var email= etEmail.text.toString()
       var password =etPassword.text.toString()
      var confirmpassword =etConfirm.text.toString()

        var error = false

        if (firstname.isBlank()) {
            error=true
            tilFirstname.error = getString(R.string.enter_first_name)

        }
        if (lastname.isBlank()) {
            error=true
           tilLastName.error = getString(R.string.enter_last_name)

        }
        if (email.isBlank()) {
            error=true

            tilEmail.error =  getString(R.string.enter_email)

        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            error=true
           tilEmail.error =  getString(R.string.enter_your_password)


        }
        if (password.isBlank()) {
            error=true
          tilPassword.error = getString(R.string.enter_password)

        }
        if (confirmpassword.isBlank()) {
            error=true
            tilConfirm.error =  getString(R.string.enter_your_password)

        }
        if (password.equals(confirmpassword)) {
            error=true
           tilConfirm.error =  getString(R.string.enter_password)



        }
        if (!error) {
            val registerRequest =
                RegisterRequest(firstname, lastname,phonenumber=String(), email, password)
//            UserViewModel.registerUser(registerRequest)

        }


    }

}