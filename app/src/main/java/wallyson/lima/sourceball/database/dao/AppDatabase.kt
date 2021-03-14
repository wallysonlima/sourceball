package wallyson.lima.sourceball.database.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import wallyson.lima.sourceball.model.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract val userDao: UserDAO

    companion object {
        private lateinit var db: AppDatabase

        fun getInstance(ctx: Context): AppDatabase {
            if (::db.isInitialized) return db

            db = Room.databaseBuilder(
                ctx,
                AppDatabase::class.java,
                "sourceball.db"
            ).build()

            return db
        }
    }
}