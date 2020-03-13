package com.example.funface.feature.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.funface.feature.Sticker
import com.example.funface.feature.StickerPack

@Dao
interface StickerPackDao {
    //Read all stickerpack
    @Query("SELECT * FROM StickerPack")
    fun getAll(): LiveData<List<StickerPack>>

    //Update stickers in a StickerPack
    @Query("UPDATE StickerPack SET stickers = (:new_stickers) WHERE name = (:name)")
    suspend fun updateStickersInStickerPack(name: String, new_stickers: MutableList<Sticker>)

    //Create a stickerpack
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun createStickerPack(stickerPack: StickerPack)

    //Delete a stickerpack
    @Delete
    suspend fun deleteStickerPack(stickerPack: StickerPack)
}