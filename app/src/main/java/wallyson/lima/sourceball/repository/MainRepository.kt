package wallyson.lima.sourceball.repository

import wallyson.lima.sourceball.database.dao.UserDAO
import wallyson.lima.sourceball.model.User

class MainRepository (private val userDao: UserDAO) {
    // Get one user
    fun getUser(email: String): User {
        return userDao.getUser(email)
    }

    // Insert one user
    fun insertUser(email: String, password: String) {
        userDao.insertUser( User(email, password) )
    }

    // make login
    fun doLogin(email: String, password: String) : User {
        return userDao.doLogin(email, password)
    }
}