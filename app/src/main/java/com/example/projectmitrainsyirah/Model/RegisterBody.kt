package com.example.projectmitrainsyirah.Model

import com.google.gson.annotations.SerializedName

data class RegisterBody(
    @SerializedName("nama_pengguna")
    val nama_pengguna: String,
    @SerializedName("alamat_pengguna")
    val alamat_pengguna: String,
    @SerializedName("email")
    var email: String,
    @SerializedName("nama_usaha")
    var nama_usaha: String,
    @SerializedName("password")
    var password:String
)