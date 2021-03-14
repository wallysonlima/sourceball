package wallyson.lima.sourceball.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.annotation.*
import wallyson.lima.sourceball.model.User
import wallyson.lima.sourceball.repository.MainRepository

class MainViewModel (
    private val repository: MainRepository
) : ViewModel() {

    fun getUser(email : String) : User {
       return repository.getUser(email)
    }

    fun inserUser(email : String, password: String) {
       repository.insertUser(email, password)
    }

    fun doLogin(email: String, password: String) {
        repository.doLogin(email, password)
    }
}