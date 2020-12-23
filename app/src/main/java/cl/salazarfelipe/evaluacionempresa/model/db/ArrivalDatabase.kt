package cl.salazarfelipe.evaluacionempresa.model.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ArrivalEntity::class], version = 1)
abstract class ArrivalDatabase : RoomDatabase() {

    abstract fun arrivalDao() : ArrivalDao

    companion object {
        @Volatile
        private var INSTANCE: ArrivalDatabase? = null

        fun getDatabase(context: Context): ArrivalDatabase {
            val tempInstance =
                INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ArrivalDatabase::class.java,
                    "hero_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}