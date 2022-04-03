import android.app.Application
import com.example.qrcone.core.QrConeApp
import com.example.qrcone.di.module.UiModule
import com.example.qrcone.presentation.MainActivity
import com.example.qrcone.presentation.create.CreateFragment
import com.example.qrcone.presentation.description.DescriptionFragment
import com.example.qrcone.presentation.list.ListFragment
import com.example.qrcone.presentation.qrcreated.QrCodeCreatedFragment
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
    modules = [
        DataModule::class,
        ViewModelModule::class,
        DomainModule::class,
        NetModule::class,
        UiModule::class
    ]
)

interface ApplicationComponent {

    fun inject(activity: MainActivity)

    fun inject(listFragment: ListFragment)

    fun inject(descriptionFragment: DescriptionFragment)

    fun inject(createFragment: CreateFragment)

    fun inject(qrCodeCreatedFragment: QrCodeCreatedFragment)

    fun inject(application: QrConeApp)

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance application: Application,
        ): ApplicationComponent
    }
}
