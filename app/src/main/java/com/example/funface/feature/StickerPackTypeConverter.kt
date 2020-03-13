package com.example.funface.feature

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class StickerPackTypeConverter {
    val gson: Gson = Gson()

    @TypeConverter
    fun stringToStickers(json: String): MutableList<Sticker> {
        return gson.fromJson(json, object: TypeToken<MutableList<Sticker>>(){}.type)
    }

    @TypeConverter
    fun stickersToString(stickers: MutableList<Sticker>): String{
        return gson.toJson(stickers)

    }
}