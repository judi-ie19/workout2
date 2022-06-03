package com.owuoremmah.workoutlogactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class loginActivity : AppCompatActivity() {
    lateinit var btnLogin: Button
    lateinit var tilEmail: TextInputLayout
    lateinit var etEmail: TextInputEditText
    lateinit var tilPassword: TextInputLayout
    lateinit var etPassword: TextInputEditText

    //   lateinit var btnsignup: Button
    lateinit var tvSignup: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)

        btnLogin = findViewById(R.id.btnLogin)
        tilEmail = findViewById(R.id.tilEmail)
        etEmail = findViewById(R.id.etEmail)
        tilPassword = findViewById(R.id.tilPassword)
        etPassword = findViewById(R.id.etPassword)
//       btnsignup = findViewById(R.id.btnsignup)
        tvSignup = findViewById(R.id.tvSignup)


        tvSignup.setOnClickListener {
            var intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
        btnLogin.setOnClickListener {
            validatelogin()
        }
    }



    fun validatelogin(){
//        var error = false
//        tilEmail.error = null
//        tilPassword.error = null
////        tilEmail.error removes all errors before and allows fresh input to be checked
//        var email =etEmail.text.toString()
//        if (email.isBlank()){
//            tilEmail.error = "Email is required"
//            error = true
////            removed the return keyword
//        }
//        var password=etPassword.text.toString()
//        if (password.isBlank()){
//            tilPassword.error = "Password is required"
//            error=true
//        }
//        if (!error){
//
//        }
        var email=etEmail.text.toString()
        var password = etPassword.text.toString()
        if (email.isBlank()){
            tilEmail.error="email is required"
        }
        if (password.isBlank()){
            tilPassword.error="password is required"
        }
    }
}
