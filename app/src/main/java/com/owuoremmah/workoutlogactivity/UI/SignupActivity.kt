package com.owuoremmah.workoutlogactivity.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.owuoremmah.workoutlogactivity.API.APiClient
import com.owuoremmah.workoutlogactivity.API.ApiInterface
import com.owuoremmah.workoutlogactivity.databinding.ActivitySignupBinding
import com.owuoremmah.workoutlogactivity.models.RegisterRequest
import com.owuoremmah.workoutlogactivity.models.RegisterResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignupActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        validatesignup()




        binding.tvLogin.setOnClickListener {
            var intent = Intent(this, loginActivity::class.java)
            startActivity(intent)
        }
        binding.btnSignup.setOnClickListener {
            validatesignup()

        }

    }

    fun validatesignup() {
        val error = false

        val firstname = binding.etFirstName.text.toString()
        val lastname = binding.etLastName.text.toString()
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()
        val confirmpassword = binding.etConfirm.text.toString()



        if (firstname.isBlank()) {
            binding.tilFirstname.error = "First name is required"

        }
        if (lastname.isBlank()) {
            binding.tilLastName.error = "Last name is required"

        }
        if (email.isBlank()) {
            binding.tilEmail.error = "email is required"


        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.tilEmail.error = "Not a valid email address"


        }
        if (password.isBlank()) {
            binding.tilPassword.error = "Password is required"

        }
        if (confirmpassword.isBlank()) {
            binding.tilConfirm.error = "confirm password"


        }
        if (password.equals(confirmpassword)) {
            binding.tilConfirm.error = "do not match"


        }
        if (!error) {
            val registerRequest =
                RegisterRequest(firstname, lastname,phonenumber=String(), email, password)
            return makeregisterRequest(registerRequest)

        }


    }

    fun makeregisterRequest(registerRequest: RegisterRequest) {
        val aPiClient = APiClient.buildApiClient(ApiInterface::class.java)
        val request = aPiClient.registerUser(registerRequest)

        request.enqueue(object : Callback<RegisterResponse> {
            override fun onResponse(
                call: Call<RegisterResponse>,
                response: Response<RegisterResponse>
            ) {
                if (response.isSuccessful) {
                    Toast.makeText(baseContext, response.body()?.message, Toast.LENGTH_LONG).show()


                }
                else{
                    val error=response.errorBody()?.string()
                    Toast.makeText(baseContext,response.body()?.message,Toast.LENGTH_LONG).show()
                }

            }

            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }


        })

    }

}





