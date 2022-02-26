import androidx.lifecycle.ViewModel
import com.example.qrcone.presentation.list.ListViewModel

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ListViewModel::class)
    fun bindListViewModel(viewModel: ListViewModel): ViewModel

//    @Binds
//    @IntoMap
//    @ViewModelKey(DescriptionViewModel::class)
//    fun bindDescriptionViewModel(viewModel: DescriptionViewModel): ViewModel
//
//    @Binds
//    @IntoMap
//    @ViewModelKey(CreateViewModel::class)
//    fun bindCreateViewModel(viewModel: CreateViewModel): ViewModel
//
//    @Binds
//    @IntoMap
//    @ViewModelKey(QrCodeCreatedViewModel::class)
//    fun bindQrCodeCreatedViewModel(viewModel: QrCodeCreatedViewModel): ViewModel


}