package com.taquangtu.kantektest.Interfaces

import com.taquangtu.kantektest.Models.User
import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Query

interface Api {
    @POST("user/login")
    fun login(@Query("email") userName:String,@Query("password") password:String): Call<User>
    fun logout():Boolean
}