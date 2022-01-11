package com.example.bluebirdrestaurant

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.bluebirdrestaurant.databinding.FragmentSegonPlatBinding


class SegonPlat : Fragment() {
    private lateinit var viewModel: PlatsM

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentSegonPlatBinding>(inflater,
            R.layout.fragment_segon_plat,container,false)



        val spinner: Spinner = binding.segonPlatspinner

        ArrayAdapter.createFromResource(
            requireActivity().applicationContext,
            R.array.segon_plat_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        spinner.selectedItem.toString()

        binding.nextPostres.setOnClickListener { view : View ->
            if(spinner.selectedItem==""){
                Toast.makeText(activity, "No has selecionat el plat", Toast.LENGTH_SHORT).show()
            }
            else {
                var platSelecionat = spinner.selectedItem.toString()
                viewModel.segonplatSeleccionat(platSelecionat)
                view.findNavController().navigate(R.id.action_segonPlat_to_postres)

            }
        }
        return binding.root
    }

}