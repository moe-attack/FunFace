package com.example.funface.feature.viewModel

import android.app.Application
import androidx.annotation.NonNull
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.funface.feature.Sticker
import com.example.funface.feature.StickerPack
import com.example.funface.feature.database.StickerPackDatabase
import com.example.funface.feature.repository.ApplicationRepository
import kotlinx.coroutines.launch

class StickerPackViewModel(@NonNull application: Application, stickerPackPrimaryKeyParam: Int): AndroidViewModel(application) {
    private val repository: ApplicationRepository
    var stickerPackPrimaryKey = stickerPackPrimaryKeyParam
    var stickerPack: StickerPack? = null
    var stickers = MutableLiveData<MutableList<Sticker>>()

    init{
        val dao = StickerPackDatabase.getDatabase(application).stickerPackDao()
        repository = ApplicationRepository(dao)
        viewModelScope.launch {
            stickerPack = repository.setUpStickers(stickerPackPrimaryKey)
            stickers.value = stickerPack?.stickers ?: mutableListOf()
        }
    }

    fun addNewSticker() {
        stickers.value!!.add(
            Sticker(
                stickerPack!!.stickerCounter,
                "",
                listOf(),
                0
            )
        )
        stickerPack!!.stickerCounter += 1
        viewModelScope.launch {
            repository.update(stickerPackPrimaryKey, stickers.value!!)
        }
    }
}