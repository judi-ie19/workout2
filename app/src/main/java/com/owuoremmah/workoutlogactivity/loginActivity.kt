package com.owuoremmah.workoutlogactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.owuoremmah.workoutlogactivity.databinding.ActivityLogin2Binding

class loginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLogin2Binding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogin2Binding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.tvSignup.setOnClickListener {
            var intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
        binding.btnLogin.setOnClickListener {
            validatelogin()
            startActivity(Intent(this,HomePageActivity::class.java))
        }
    }



    fun validatelogin(){
        var error=false
        binding.tilEmail.error=null
        binding.tilEmail.error=null
        var email=binding.etEmail.text.toString()
        var password = binding.etPassword.text.toString()
        if (email.isBlank()){
            binding.tilEmail.error="email is required"
            error=true
        }
        if (password.isBlank()){
            binding.tilPassword.error="password is required"
            error=true
        }
    }
}
