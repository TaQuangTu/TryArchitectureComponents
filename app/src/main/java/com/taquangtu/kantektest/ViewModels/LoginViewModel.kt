package com.taquangtu.kantektest.ViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.taquangtu.kantektest.Interfaces.Api
import com.taquangtu.kantektest.Models.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginViewModel : ViewModel() {
    private val BASE_URL = "http://yelp-test.kennjdemo.com/api/v1/"
    private var mRetrofit: Retrofit
    private var mApi:Api
    private var mUser: MutableLiveData<User>

    init {
        mRetrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        mApi = mRetrofit.create(Api::class.java)
        mUser = MutableLiveData()
    }
    fun getUser(): MutableLiveData<User>{
        return mUser
    }
    fun loadUser(userName: String ="", pass: String =""){
        val call: Call<User> = mApi.login(userName,pass)
        call.enqueue(object : Callback<User> {

            override fun onResponse(call: Call<User>?, response: Response<User>?) {
                if(response!=null){
                    if(response.body()!=null){
                        val user = response.body()
                        mUser?.postValue(user)
                        return
                    }
                }
                val message = if(response?.message()!=null) response.message() else "something wrongs"
                mUser?.postValue(User(null,message,false))

            }

            override fun onFailure(call: Call<User>?, t: Throwable?) {
                val message = if(t?.localizedMessage!=null) t.localizedMessage else "something wrongs"
                mUser?.postValue(User(null, message,false))
            }
        })
    }
}
