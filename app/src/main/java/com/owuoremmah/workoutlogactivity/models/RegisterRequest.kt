package com.owuoremmah.workoutlogactivity.models

import android.provider.ContactsContract
import com.google.gson.annotations.SerializedName

data class RegisterRequest(

    @SerializedName("first_name")  var  firstname:String,
    @SerializedName("last_name")   var lastname:String,
    @SerializedName("phone_number")  var phonenumber:String,
    @SerializedName("email")        var email: String,
    @SerializedName("password")     var password:String,



    )
