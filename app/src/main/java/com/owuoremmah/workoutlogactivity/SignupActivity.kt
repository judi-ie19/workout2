package com.owuoremmah.workoutlogactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignupActivity : AppCompatActivity() {
    lateinit var tilEmail: TextInputLayout
    lateinit var tilPassword: TextInputLayout
    lateinit var tilFirstName: TextInputLayout
    lateinit var tvLogin: TextView
    lateinit var tilLastName: TextInputLayout
    lateinit var tilconfirm: TextInputLayout
    lateinit var btnSignup: Button
    lateinit var etEmail: TextInputEditText
    lateinit var etPassword: TextInputEditText
    lateinit var etFirstName: TextInputEditText
    lateinit var etLastName: TextInputEditText
    lateinit var etConfirm: TextInputEditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        btnSignup = findViewById(R.id.btnSignup)
        tilFirstName = findViewById(R.id.tilFirstname)
        tilPassword = findViewById(R.id.tilPassword)
        tilEmail = findViewById(R.id.tilEmail)
        tilconfirm = findViewById(R.id.tilConfirm)
        tilLastName = findViewById(R.id.tilLastName)
        etConfirm = findViewById(R.id.etConfirm)
        etLastName = findViewById(R.id.etLastName)
        etPassword = findViewById(R.id.etPassword)
        etFirstName = findViewById(R.id.etFirstName)
        etEmail = findViewById(R.id.etEmail)
        tvLogin=findViewById(R.id.tvLogin)




        tvLogin.setOnClickListener {
            var intent=Intent(this,loginActivity::class.java)
            startActivity(intent)
        }
        btnSignup.setOnClickListener {
            validatesignup()

        }

    }

    fun validatesignup() {
        var error=false
        tilEmail.error=null
        tilLastName.error=null
        tilconfirm.error=null
        tilFirstName.error=null
        tilPassword.error=null
        var firstname = etFirstName.text.toString()
        var lastname = etLastName.text.toString()
        var email = etEmail.text.toString()
        var password = etPassword.text.toString()
        var confirmpassword = etConfirm.text.toString()


        if (firstname.isBlank()) {
            tilFirstName.error = "First name is required"
            error=true
        }
        if (lastname.isBlank()) {
            tilLastName.error = "Last name is required"
            error=true
        }
        if (email.isBlank()) {
            tilEmail.error = "email is required"
            error=true

        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            tilEmail.error="Not a valid email address"
            error=true

        }
        if (password.isBlank()) {
            tilPassword.error = "Password is required"
            error=true
        }
        if (confirmpassword.isBlank()) {
            tilconfirm.error = "confirm password"
            error=true


        }
        if (password != confirmpassword) {
            tilconfirm.error = "do not match"
            error=true
        }
        if (!error){

        }

    }
}





