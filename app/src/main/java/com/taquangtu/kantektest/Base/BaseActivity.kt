package com.taquangtu.kantektest.Base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }

    override fun onStart() {
        super.onStart()
        mapViews()
        regislistener()
    }

    override fun onResume() {
        super.onResume()
        presentData()
    }

    open fun mapViews() {
        //find view by id
    }

    open fun unregistlistener() {

    }

    open fun regislistener() {

    }

    open fun presentData() {

    }

    open fun refetchData() {

    }

    override fun onDestroy() {
        super.onDestroy()
        unregistlistener()
    }
}