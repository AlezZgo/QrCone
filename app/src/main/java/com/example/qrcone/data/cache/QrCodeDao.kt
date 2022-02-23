package com.example.qrcone.data.cache

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.qrcone.data.cache.QrCodeCache

@Dao
interface QrCodeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(qrCode: QrCodeCache)

    @Query("SELECT * FROM qrCodes ORDER BY title ASC")
    fun qrCodeList(): LiveData<List<QrCodeCache>>

}