package com.example.funface.feature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.funface.extension.hideSoftKeyboard

abstract class BaseFragment: Fragment() {
    fun hideKeyboard() {
        activity?.run{
            hideSoftKeyboard()
        }
    }
}