import android.app.Application
import com.example.qrcone.data.QrCodeRepository
import com.example.qrcone.data.cache.AppDatabase
import com.example.qrcone.data.cache.CacheDataSource
import com.example.qrcone.data.cache.QrCodeDao
import com.example.qrcone.data.cloud.CloudDataSource
import com.example.qrcone.data.mapper.QrCodeCacheToDataMapper
import com.example.qrcone.data.mapper.QrCodeDataToDomainMapper

import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindShopListRepository(impl: QrCodeRepository.Base): QrCodeRepository

    @ApplicationScope
    @Binds
    fun bindRemoteDataSource(impl: CloudDataSource.Test): CloudDataSource

    companion object {

        @ApplicationScope
        @Provides
        fun provideCharacterListDao(
            application: Application,
        ): QrCodeDao {
            return AppDatabase.instance(application).qrCodeDao()
        }

        @ApplicationScope
        @Provides
        fun provideLocalDataSource(
            application: Application,
        ): CacheDataSource {
            return CacheDataSource.Base(AppDatabase.instance(application).qrCodeDao())
        }

        @ApplicationScope
        @Provides
        fun provideCacheToDataMapper() : QrCodeCacheToDataMapper = QrCodeCacheToDataMapper.Base()

    }
}