package com.example.funface.extension

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.FragmentActivity

fun FragmentActivity.hideSoftKeyboard(){
    val imm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    currentFocus?.run{
        imm.hideSoftInputFromWindow(windowToken, 0)
    }?: run{
        imm.hideSoftInputFromWindow(View(this).windowToken, 0)
    }
}

fun FragmentActivity.showKeyboard(view: View){
    view.requestFocus()
    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
}