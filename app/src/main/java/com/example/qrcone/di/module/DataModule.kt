import android.app.Application
import com.example.qrcone.data.QrCodeRepository
import com.example.qrcone.data.cache.AppDatabase
import com.example.qrcone.data.cache.CacheDataSource
import com.example.qrcone.data.cache.QrCodeDao
import com.example.qrcone.data.cloud.CloudDataSource
import com.example.qrcone.data.mapper.QrCodeCacheToDomainMapper

import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindQrCodeListRepository(impl: QrCodeRepository.Base): QrCodeRepository

    @ApplicationScope
    @Binds
    fun bindCloudDataSource(impl: CloudDataSource.Test): CloudDataSource

    companion object {

        @ApplicationScope
        @Provides
        fun provideQrCodeListDao(
            application: Application,
        ): QrCodeDao {
            return AppDatabase.instance(application).qrCodeDao()
        }

        @ApplicationScope
        @Provides
        fun provideCacheDataSource(
            application: Application,
        ): CacheDataSource {
            return CacheDataSource.Base(AppDatabase.instance(application).qrCodeDao())
        }

        @ApplicationScope
        @Provides
        fun provideCacheToDomainMapper() : QrCodeCacheToDomainMapper = QrCodeCacheToDomainMapper.Base()

    }
}