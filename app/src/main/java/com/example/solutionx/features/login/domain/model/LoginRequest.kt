package com.example.solutionx.features.login.domain.model

import com.google.gson.annotations.SerializedName

data class LoginRequest(
   val phone :Phone,
    val password : String ,
)
data class Phone(
//    @SerializedName("phone[country_code]")
    val country_code : String,
//    @SerializedName("phone[number]")
    val number : String ,
)
