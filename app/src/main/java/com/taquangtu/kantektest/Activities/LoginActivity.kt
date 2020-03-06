package com.taquangtu.kantektest.Activities

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.taquangtu.kantektest.Base.BaseActivity
import com.taquangtu.kantektest.Models.Data
import com.taquangtu.kantektest.Models.User
import com.taquangtu.kantektest.R
import com.taquangtu.kantektest.ViewModels.LoginViewModel
import java.lang.StringBuilder

class LoginActivity : BaseActivity(),Observer<User> {

    private lateinit var mEdtUserName: EditText
    private lateinit var mEdtPassword: EditText
    private lateinit var mBtnLogin: Button
    private lateinit var mTvUserInfo: TextView
    private lateinit var mLoginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //declear a viewModel for this activity
        mLoginViewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        //register observer
        mLoginViewModel.getUser().observe(this,this)
    }
    override fun mapViews(){
        super.mapViews()
        mEdtUserName = findViewById(R.id.edtUserName)
        mEdtPassword = findViewById(R.id.edtPassword)
        mBtnLogin = findViewById(R.id.btnLogin)
        mTvUserInfo = findViewById(R.id.tvUserInfo)
        mBtnLogin.setOnClickListener { view->
            refetchData()
        }
    }

    override fun refetchData() {
        super.refetchData()
        val userName = mEdtUserName.text.toString().trim()
        val password = mEdtPassword.text.toString().trim()
        mLoginViewModel.loadUser(userName,password)
    }

    private fun presentUserInfo(user:User?){
        if(user!=null){
            var userInfo = StringBuilder()
            userInfo.append("message = "+user.message+"\n")
            userInfo.append("result = "+user.result+"\n")
            val data: Data? = user.data
            if(data!=null){
                userInfo.append("token ="+data.access_token+"\n")
                userInfo.append("address ="+data.address+"\n")
                userInfo.append("phone ="+data.phone+"\n")
                userInfo.append("And other information...")
                //others information
            }
            mTvUserInfo.text = userInfo.toString()
        }
    }

    override fun onChanged(t: User?) {
        presentUserInfo(t)
    }

}
