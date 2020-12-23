package cl.salazarfelipe.evaluacionempresa.model.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ArrivalDao {
        @Query("SELECT * FROM arrivals_table ORDER BY id ASC")
        fun getAll(): LiveData<List<ArrivalEntity>>

        @Insert (onConflict = OnConflictStrategy.REPLACE)
        suspend fun addArrival(arrival : ArrivalEntity)

}