package com.example.funface.feature

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.funface.feature.viewModel.StickerPackViewModel

class StickerPackViewModelFactory(applicationParam: Application, stickerPackPrimaryKeyParam: Int):  ViewModelProvider.Factory{
    private val application: Application
    private val stickerPackPrimaryKey: Int

    init{
        application = applicationParam
        stickerPackPrimaryKey = stickerPackPrimaryKeyParam
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return StickerPackViewModel(application, stickerPackPrimaryKey) as (T)
    }

}