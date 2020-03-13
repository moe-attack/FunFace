package com.example.funface.feature

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import kotlinx.android.parcel.IgnoredOnParcel
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class StickerPack (
    @PrimaryKey(autoGenerate = true)
    val generatedPrimaryKey: Int = 0,
    val name: String
): Parcelable {
    @IgnoredOnParcel
    @TypeConverters(StickerPackTypeConverter::class)
    var stickers: List<Sticker> = listOf<Sticker>()
    @IgnoredOnParcel
    var totalSize: Long = 0
    @IgnoredOnParcel
    var androidPlayStoreLink: String = ""

    // TODO: set default value.
    var identifier: String = generatedPrimaryKey.toString()
    var publisher: String = ""
    var iosAppStoreLink: String = ""
    var publisherEmail: String = ""
    var publisherWebsite: String = ""
    var privacyPolicyWebsite: String = ""
    var licenseAgreementWebsite: String = ""
    var trayImageFile: String = ""
    var imageDataVersion: String = ""
    var avoidCache: Boolean = false

    fun updateTotalSize(){
        val iterator = stickers.iterator()
        iterator.forEach{
            totalSize += it.size
        }
    }
}