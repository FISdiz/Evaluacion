package cl.salazarfelipe.evaluacionempresa.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import cl.salazarfelipe.evaluacionempresa.model.Repository
import cl.salazarfelipe.evaluacionempresa.model.db.ArrivalDatabase
import cl.salazarfelipe.evaluacionempresa.model.db.ArrivalEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.DisposableHandle
import kotlinx.coroutines.launch

class UserViewModel(application: Application):AndroidViewModel(application) {

    val getAllData : LiveData<List<ArrivalEntity>>
    private val repository : Repository

    init {
        val arrivalDao = ArrivalDatabase.getDatabase(application).arrivalDao()
        repository = Repository(arrivalDao)
        getAllData = repository.getAllData
    }

    fun addArrival (arrival : ArrivalEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addArrival(arrival)
        }
    }
}