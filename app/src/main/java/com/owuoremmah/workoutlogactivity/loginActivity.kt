package com.owuoremmah.workoutlogactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class loginActivity : AppCompatActivity() {
    lateinit var btnLogin:Button
    lateinit var tilEmail:TextInputLayout
    lateinit var etEmail:TextInputEditText
    lateinit var tilPassword:TextInputLayout
    lateinit var etPassword:TextInputEditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)

        btnLogin = findViewById(R.id.btnLogin)
        tilEmail = findViewById(R.id.tilEmail)
        etEmail = findViewById(R.id.etEmail)
        tilPassword= findViewById(R.id.tilPassword)
        etPassword = findViewById(R.id.etPassword)

        btnLogin.setOnClickListener { validateLogin() }
    }
    fun validateLogin(){
        var error = false
        tilEmail.error = null
        tilEmail.error = null
//        tilEmail.error removes all errors before and allows fresh input to be checked
        var email =etEmail.text.toString()
        if (email.isBlank()){
            tilEmail.error = "Email is required"
            error = true
//            removed the return keyword
        }
        var password=etPassword.text.toString()
        if (password.isBlank()){
            tilPassword.error = "Password is required"
            error=true
        }
        if (!error){

        }
    }
}