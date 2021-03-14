package wallyson.lima.sourceball.ui.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import wallyson.lima.sourceball.repository.MainRepository
import wallyson.lima.sourceball.ui.viewmodel.MainViewModel
import java.lang.IllegalArgumentException

class MainViewModelFactory(
        private val repository: MainRepository
): ViewModelProvider.Factory{
    override fun <T: ViewModel?> create(modelClass: Class<T>): T {
        if ( modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(repository) as T
        }

        throw IllegalArgumentException("UnknownViewModel")
    }
}