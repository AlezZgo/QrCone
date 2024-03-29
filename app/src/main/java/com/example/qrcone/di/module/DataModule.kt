import android.app.Application
import com.example.qrcone.data.QrCodeCacheDomainMapper
import com.example.qrcone.data.QrCodeRepository
import com.example.qrcone.data.cache.AppDatabase
import com.example.qrcone.data.cache.CacheDataSource
import com.example.qrcone.data.cache.QrCodeDao
import com.example.qrcone.data.cloud.CloudDataSource
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindQrCodeRepository(impl: QrCodeRepository.Base): QrCodeRepository

    companion object {

        @ApplicationScope
        @Provides
        fun provideQrCodeRepository(
            qrCodeCacheDataSource: CacheDataSource,
            cloudDataSource: CloudDataSource,
            qrCodeCacheDomainMapper: QrCodeCacheDomainMapper,
            application: Application,
        ): QrCodeRepository.Base {
            return QrCodeRepository.Base(qrCodeCacheDataSource,
                cloudDataSource,
                qrCodeCacheDomainMapper,
                application)
        }

        @ApplicationScope
        @Provides
        fun provideCacheDataSource(
            qrCodeDao: QrCodeDao,
        ): CacheDataSource {
            return CacheDataSource.Base(qrCodeDao)
        }

        @ApplicationScope
        @Provides
        fun provideCacheToDomainMapper(): QrCodeCacheDomainMapper = QrCodeCacheDomainMapper.Base()


        @ApplicationScope
        @Provides
        fun provideQrCodeDao(
            application: Application,
        ): QrCodeDao {
            return AppDatabase.instance(application).qrCodeDao()
        }


    }
}