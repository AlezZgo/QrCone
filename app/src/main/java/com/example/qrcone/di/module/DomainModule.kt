import com.example.qrcone.data.QrCodeRepository
import com.example.qrcone.domain.QrCodeInteractor
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DomainModule {

    @ApplicationScope
    @Binds
    fun bindQrCodeInteractor(impl: QrCodeInteractor.Base): QrCodeInteractor

    companion object {

        @ApplicationScope
        @Provides
        fun provideQrCodeInteractor(
            repository: QrCodeRepository,
        ): QrCodeInteractor.Base {
            return QrCodeInteractor.Base(repository)
        }
    }


}