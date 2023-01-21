package com.example.projectmitrainsyirah.Model

import com.example.projectmitrainsyirah.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiInterface{
    @Headers("Content-Type:application/json")
    @POST("logins")
    fun login(@Body info: LoginBody): retrofit2.Call<ResponseBody>

    @Headers("Content-Type:application/json")
    @POST("registers")
    fun registerUser(
        @Body info: RegisterBody
    ): retrofit2.Call<ResponseBody>
}

class RetrofitInstance {
    companion object {
        val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }

        val client: OkHttpClient = OkHttpClient.Builder().apply {
            this.addInterceptor(interceptor)
        }.build()

        fun getRetrofitInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL.NGROK_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}