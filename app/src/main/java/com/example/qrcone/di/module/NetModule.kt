import com.example.qrcone.data.cloud.CloudDataSource
import com.example.qrcone.data.cloud.QrConeApiService
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
interface NetModule {

    @ApplicationScope
    @Binds
    fun bindQrCodeCloudDataSource(impl: CloudDataSource.Test): CloudDataSource

    companion object {
        @Provides
        @ApplicationScope
        fun provideOkHttpClient(interceptor: HttpLoggingInterceptor) =
            OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()

        @Provides
        @ApplicationScope
        fun provideInterceptor() = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        @Provides
        @ApplicationScope
        fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
            Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .build()

        @Provides
        @ApplicationScope
        fun provideApiService(retrofit: Retrofit): QrConeApiService {
            return retrofit.create(QrConeApiService::class.java)
        }

        private const val baseUrl = "https://qrcone.herokuapp.com/"

    }

}