package com.taquangtu.kantektest.Base

import android.view.View
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager

open class BaseDialog : DialogFragment(){
    companion object{
        const val DIALOG_TAG = "DIALOG"
    }
    fun show(fragmentManager:FragmentManager){
        show(fragmentManager,DIALOG_TAG)
    }
    fun hide(){
        dismiss()
    }
    fun <T : View> findView(id: Int): T? {
        return view?.findViewById(id) as? T
    }
}
