package wallyson.lima.sourceball.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import wallyson.lima.sourceball.model.User

@Dao
interface UserDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user : User)

    @Query("SELECT * FROM User WHERE name LIKE :name LIMIT 1;")
    fun getUser(name: String): User

    @Query("SELECT * FROM User WHERE name LIKE :name AND password LIKE :password LIMIT 1;")
    fun doLogin(name: String, password: String): User
}