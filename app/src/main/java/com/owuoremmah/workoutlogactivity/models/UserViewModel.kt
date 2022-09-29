package com.owuoremmah.workoutlogactivity.models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.owuoremmah.workoutlogactivity.Repository.UserRepository
import com.owuoremmah.workoutlogactivity.models.LoginRequest
import com.owuoremmah.workoutlogactivity.models.LoginResponse
import kotlinx.coroutines.launch

class UserViewModel :ViewModel(){
    val userRepository=UserRepository()
    val loginResponseLiveData= MutableLiveData<LoginResponse>()
    val errorLiveData=MutableLiveData<String>()

    fun loginUSer(loginRequest: LoginRequest){
        viewModelScope.launch {
            val response=userRepository.loginUser(loginRequest)
            if (response.isSuccessful){
                loginResponseLiveData.postValue(response.body())
            }
            else{
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }

    }
}