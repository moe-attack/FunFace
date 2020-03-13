package com.example.funface.feature.repository

import androidx.lifecycle.LiveData
import androidx.room.Dao
import com.example.funface.feature.Sticker
import com.example.funface.feature.StickerPack
import com.example.funface.feature.database.StickerPackDao

class ApplicationRepository(private val dao: StickerPackDao) {
    val allStickerPacks: LiveData<List<StickerPack>> = dao.getAll()

    suspend fun insert(stickerpack: StickerPack){
        dao.createStickerPack(stickerpack)
    }

    suspend fun delete(stickerpack: StickerPack){
        dao.deleteStickerPack(stickerpack)
    }

    suspend fun update(name: String, stickers: MutableList<Sticker>){
        dao.updateStickersInStickerPack(name, stickers)
    }

}