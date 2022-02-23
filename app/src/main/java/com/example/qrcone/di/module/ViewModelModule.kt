import androidx.lifecycle.ViewModel
import com.example.qrcone.presentation.create.CreateViewModel
import com.example.qrcone.presentation.description.DescriptionViewModel
import com.example.qrcone.presentation.list.ListViewModel

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CreateViewModel::class)
    fun bindCreateViewModel(viewModel: CreateViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ListViewModel::class)
    fun bindFavouritesViewModel(viewModel: ListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DescriptionViewModel::class)
    fun bindDescriptionViewModel(viewModel: DescriptionViewModel): ViewModel
}