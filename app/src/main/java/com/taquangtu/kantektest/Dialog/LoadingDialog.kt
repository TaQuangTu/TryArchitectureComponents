package com.taquangtu.kantektest.Dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.taquangtu.kantektest.Base.BaseDialog
import com.taquangtu.kantektest.R

class LoadingDialog : BaseDialog(){

    private lateinit var mMessage:String
    private var tvMessage: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.dialog_loading,container,false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isCancelable = false
        tvMessage = findView(R.id.tvMessage)
        tvMessage?.text = mMessage
    }
    fun setMessage(message:String){
        mMessage = message
    }
}
