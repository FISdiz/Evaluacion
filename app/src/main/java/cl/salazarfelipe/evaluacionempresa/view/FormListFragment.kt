package cl.salazarfelipe.evaluacionempresa.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import cl.salazarfelipe.evaluacionempresa.R
import cl.salazarfelipe.evaluacionempresa.model.db.ArrivalEntity
import cl.salazarfelipe.evaluacionempresa.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_form_list.view.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class FormList : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    private lateinit var mUserViewModel : UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_form_list, container, false)

        val adapter = FormListAdapter()
        val recyclerView = view.recyclerview
        recyclerView.adapter = adapter

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        mUserViewModel.getAllData.observe(viewLifecycleOwner, Observer { arrival ->
            adapter.setData(arrival)
        })


        return view
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FormList().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}