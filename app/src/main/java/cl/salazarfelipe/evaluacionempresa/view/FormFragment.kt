package cl.salazarfelipe.evaluacionempresa.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import cl.salazarfelipe.evaluacionempresa.R
import cl.salazarfelipe.evaluacionempresa.model.db.ArrivalEntity
import cl.salazarfelipe.evaluacionempresa.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_form.*
import java.util.*
import kotlin.math.cos

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class FormFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var mUserViewModel : UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_form, container, false)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)



        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FormFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_save.setOnClickListener {
            insertDataToDatabase()
        }
    }

    private fun insertDataToDatabase() {
        val nave = txt_nave.text.toString()
        val matricula = txt_matricula.text.toString()
        val fechaCompra = txt_fcompra.text.toString()
        val fechaMantencion = txt_fmantencion.text.toString()
        val capitan = txt_capitan.text.toString()
        val costoAcumulado = txt_costo.text.toString()

        if (txt_nave!=null && txt_matricula!=null && txt_fcompra!=null && txt_fmantencion!=null && txt_capitan!=null && txt_costo!=null) {
            val arrival = ArrivalEntity(0,nave, matricula, fechaCompra, fechaMantencion,capitan,costoAcumulado)
            mUserViewModel.addArrival(arrival)
            Toast.makeText(context, "Agregado con éxito", Toast.LENGTH_SHORT).show()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.main_container,FormList.newInstance("",""),"FormList")
                .addToBackStack("FormList")
                .commit()
        }

        else {
            Toast.makeText(context, "Por favor, rellene todos los datos", Toast.LENGTH_SHORT).show()
        }
    }

}