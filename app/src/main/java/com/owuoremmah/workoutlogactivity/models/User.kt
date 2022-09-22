package com.owuoremmah.workoutlogactivity.models

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("first_name")  var  firstname:String,
    @SerializedName("last_name")   var lastname:String,
    @SerializedName("phone_number") var phonenumber:String,
    @SerializedName("email")        var email: String,
    @SerializedName("password")     var password:String,

    )
