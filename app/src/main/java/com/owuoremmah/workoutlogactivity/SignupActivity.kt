package com.owuoremmah.workoutlogactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.owuoremmah.workoutlogactivity.databinding.ActivityLogin2Binding
import com.owuoremmah.workoutlogactivity.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {
   lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySignupBinding.inflate(layoutInflater)
        validatesignup()






        binding.tvLogin.setOnClickListener {
            var intent=Intent(this,loginActivity::class.java)
            startActivity(intent)
        }
        binding.btnSignup.setOnClickListener {
            validatesignup()

        }

    }

    fun validatesignup() {

        var firstname = binding.etFirstName.text.toString()
        var lastname = binding.etLastName.text.toString()
        var email = binding.etEmail.text.toString()
        var password =binding. etPassword.text.toString()
        var confirmpassword = binding.etConfirm.text.toString()


        if (firstname.isBlank()) {
            binding.tilFirstname.error= "First name is required"
        }
        if (lastname.isBlank()) {
            binding.tilLastName.error = "Last name is required"

        }
        if (email.isBlank()) {
           binding. tilEmail.error = "email is required"


        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            binding.tilEmail.error="Not a valid email address"


        }
        if (password.isBlank()) {
            binding.tilPassword.error = "Password is required"

        }
        if (confirmpassword.isBlank()) {
            binding.tilConfirm.error = "confirm password"


        }
        if (password != confirmpassword) {
           binding.tilConfirm.error = "do not match"

        }



    }
}





