package com.example.bluebirdrestaurant

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.bluebirdrestaurant.databinding.FragmentPrimerPlatBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PrimerPlat.newInstance] factory method to
 * create an instance of this fragment.
 */
class PrimerPlat : Fragment() {

    private lateinit var viewModel: PlatsM

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentPrimerPlatBinding>(inflater,
            R.layout.fragment_primer_plat,container,false)

        viewModel = ViewModelProvider(this).get(PlatsM::class.java)

        val spinner: Spinner = binding.primerPlatspinner

        ArrayAdapter.createFromResource(
            requireActivity().applicationContext,
            R.array.primer_plat_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

            binding.nextSegonPlat.setOnClickListener {view : View ->
                if(spinner.selectedItem==""){
                    Toast.makeText(activity, "No has selecionat el plat", Toast.LENGTH_SHORT).show()
                }
                else {
                    //esta linea te guarda lo selecionado
                    var platSelecionat = spinner.selectedItem.toString()
                    viewModel.primerplatSeleccionat(platSelecionat)
                    view.findNavController().navigate(R.id.action_primerPlat_to_segonPlat)
                }
            }

        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PrimerPlat.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PrimerPlat().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }




}