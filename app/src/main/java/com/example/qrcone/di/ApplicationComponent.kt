import android.app.Application
import com.example.starwarscharacters.presentation.MainActivity
import com.example.starwarscharacters.presentation.StarWarsApp
import com.example.starwarscharacters.presentation.characters.CharactersFragment
import com.example.starwarscharacters.presentation.description.DescriptionFragment
import com.example.starwarscharacters.presentation.favourites.FavouritesFragment
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
    modules = [
        DataModule::class,
        ViewModelModule::class,
        NetModule::class
    ]
)

interface ApplicationComponent {

    fun inject(activity: MainActivity)

    fun inject(charactersFragment: CharactersFragment)

    fun inject(favouritesFragment: FavouritesFragment)

    fun inject(descriptionFragment: DescriptionFragment)

    fun inject(application: StarWarsApp)

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance application: Application,
        ): ApplicationComponent
    }
}
