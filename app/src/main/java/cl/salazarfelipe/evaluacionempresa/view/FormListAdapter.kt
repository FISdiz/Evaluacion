package cl.salazarfelipe.evaluacionempresa.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.salazarfelipe.evaluacionempresa.R
import cl.salazarfelipe.evaluacionempresa.model.db.ArrivalEntity
import kotlinx.android.synthetic.main.single_arrival.view.*

class FormListAdapter : RecyclerView.Adapter<FormListAdapter.MyViewHolder>() {

    private var arrivalList = emptyList<ArrivalEntity>()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.single_arrival, parent, false))
    }

    override fun getItemCount():Int {
        return arrivalList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val arrivalItem = arrivalList[position]
        holder.itemView.txt_cap_list.text = arrivalItem.capitan
        holder.itemView.txt_nave_list.text = arrivalItem.nave
        holder.itemView.txt_mat_list.text = arrivalItem.matricula
        holder.itemView.txt_ca_list.text = arrivalItem.costoAcumulado
        holder.itemView.txt_fc_list.text = arrivalItem.fechaCompra
        holder.itemView.txt_fm_list.text = arrivalItem.fechaMantencion
    }

    fun setData(arrival : List<ArrivalEntity>){
        this.arrivalList = arrival
        notifyDataSetChanged()
    }
}