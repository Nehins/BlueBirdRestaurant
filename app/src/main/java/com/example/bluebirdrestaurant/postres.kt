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
import com.example.bluebirdrestaurant.databinding.FragmentPostresBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [postres.newInstance] factory method to
 * create an instance of this fragment.
 */
class postres : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var viewModel: PlatsM


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentPostresBinding>(inflater,
            R.layout.fragment_postres,container,false)

        val spinner: Spinner = binding.postresspinner


        ArrayAdapter.createFromResource(
            requireActivity().applicationContext,
            R.array.postre,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        val postres = spinner.selectedItem.toString()

        binding.nextFiMenu.setOnClickListener { view : View ->
            if(spinner.selectedItem==""){
                Toast.makeText(activity, "No has selecionat el plat", Toast.LENGTH_SHORT).show()
            }
            else {
                view.findNavController().navigate(R.id.action_postres_to_pagament)
                var platSelecionat = spinner.selectedItem.toString()
                viewModel.postreSeleccionat(platSelecionat)
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
         * @return A new instance of fragment postres.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            postres().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

}