package com.example.solutionx.features.login.data.models.dto


import com.google.gson.annotations.SerializedName

 data class UserDto(
    @SerializedName("all_permissions")
    val allPermissions: List<Any?>? = null,
    @SerializedName("birthdate")
    val birthdate: Any? = null,
    @SerializedName("blocked")
    val blocked: Int? = null,
    @SerializedName("country")
    val country: CountryDto? = null,
    @SerializedName("email")
    val email: String? = null,
    @SerializedName("email_verified")
    val emailVerified: Boolean? = null,
    @SerializedName("firstname")
    val firstname: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("image")
    val image: Any? = null,
    @SerializedName("lastname")
    val lastname: String? = null,
    @SerializedName("middlename")
    val middlename: String? = null,
    @SerializedName("phone")
    val phone: PhoneDto? = null,
    @SerializedName("phone_verified")
    val phoneVerified: Boolean? = null,
    @SerializedName("username")
    val username: String? = null
)