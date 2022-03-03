import android.app.Application
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
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
        ): QrCodeRepository.Base {
            return QrCodeRepository.Base(qrCodeCacheDataSource,
                cloudDataSource,
                qrCodeCacheDomainMapper)
        }

        @ApplicationScope
        @Provides
        fun provideCacheDataSource(
            qrCodeDao: QrCodeDao,
            sharedPreferences: SharedPreferences
        ): CacheDataSource {
            return CacheDataSource.Base(qrCodeDao,sharedPreferences)
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

        @ApplicationScope
        @Provides
        fun provideEncryptedSharedPrefs(
            application: Application,
            masterKeyAlias: String
        ): SharedPreferences {
                return EncryptedSharedPreferences.create(
                    "secret_shared_prefs",
                    masterKeyAlias,
                    application,
                    EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                    EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
                )
        }

        @ApplicationScope
        @Provides
        fun provideMasterKeyAlias() = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)
    }
}