package com.example.funface.feature.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.funface.feature.StickerPack
import com.example.funface.feature.StickerPackTypeConverter

@Database(entities = arrayOf(StickerPack::class), version = 1)
@TypeConverters(StickerPackTypeConverter::class)
public abstract class StickerPackDatabase: RoomDatabase() {
    abstract fun stickerPackDao(): StickerPackDao

    companion object {
        @Volatile
        private var INSTANCE: StickerPackDatabase ?= null

        fun getDatabase(context: Context): StickerPackDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    StickerPackDatabase::class.java,
                    "stickerPackDatabse")
                    .addMigrations(MIGRATION_1_2)
                    .build()
                INSTANCE = instance
                return instance
            }
        }

        val MIGRATION_1_2 = object: Migration(1, 2){
            override fun migrate(database: SupportSQLiteDatabase){}
        }
    }
}