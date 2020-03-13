package com.example.funface.feature.viewModel

import android.app.Application
import androidx.annotation.NonNull
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.funface.feature.Sticker
import com.example.funface.feature.StickerPack
import com.example.funface.feature.database.StickerPackDatabase
import com.example.funface.feature.repository.ApplicationRepository
import kotlinx.coroutines.launch

class CollectionViewModel(@NonNull application: Application): AndroidViewModel(application) {
    private val repository: ApplicationRepository
    val allStickerPacks: LiveData<List<StickerPack>>

    init {
        val dao = StickerPackDatabase.getDatabase(application).stickerPackDao()
        repository = ApplicationRepository(dao)
        allStickerPacks = repository.allStickerPacks
    }

    fun insert(stickerPack: StickerPack){
        viewModelScope.launch {
            repository.insert(stickerPack)
        }
    }

    fun delete(stickerPack: StickerPack){
        viewModelScope.launch {
            repository.delete(stickerPack)
        }
    }

    fun update(name: String, stickers: MutableList<Sticker>){
        viewModelScope.launch {
            repository.update(name, stickers)
        }
    }

}