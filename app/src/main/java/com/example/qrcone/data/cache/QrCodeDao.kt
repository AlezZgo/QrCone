package com.example.qrcone.data.cache

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface QrCodeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(qrCode: QrCodeCache)

    @Query("DELETE FROM qrCodes WHERE title=:title")
    suspend fun delete(title: String)

    @Query("SELECT * FROM qrCodes ORDER BY title ASC")
    fun qrCodeList(): LiveData<List<QrCodeCache>>

}