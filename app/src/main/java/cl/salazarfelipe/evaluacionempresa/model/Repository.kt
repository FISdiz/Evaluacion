package cl.salazarfelipe.evaluacionempresa.model

import android.content.Context
import androidx.lifecycle.LiveData
import cl.salazarfelipe.evaluacionempresa.model.db.ArrivalDao
import cl.salazarfelipe.evaluacionempresa.model.db.ArrivalDatabase
import cl.salazarfelipe.evaluacionempresa.model.db.ArrivalEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Repository(private val arrivalDao : ArrivalDao) {

    val getAllData : LiveData<List<ArrivalEntity>> = arrivalDao.getAll()

    suspend fun addArrival(arrival : ArrivalEntity){
        arrivalDao.addArrival(arrival)
    }
}