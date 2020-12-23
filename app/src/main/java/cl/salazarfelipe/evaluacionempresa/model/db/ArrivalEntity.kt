package cl.salazarfelipe.evaluacionempresa.model.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "arrivals_table")
data class ArrivalEntity (
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val nave: String,
    val matricula: String,
    val fechaCompra: String,
    val fechaMantencion: String,
    val capitan: String,
    val costoAcumulado: String
)