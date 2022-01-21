package com.example.bluebirdrestaurant.pagament

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.bluebirdrestaurant.R
import com.example.bluebirdrestaurant.Recursos.SharedApp
import com.example.bluebirdrestaurant.data.BlueBirdDatabase
import com.example.bluebirdrestaurant.databinding.FragmentPagamentBinding
import com.example.bluebirdrestaurant.registre.RegistreVM
import com.example.bluebirdrestaurant.registre.RegistreVMFactory
import java.math.BigDecimal
import java.math.RoundingMode


class Pagament : Fragment() {

    private lateinit var pagament : PagamentVM
    private lateinit var viewModel : PagamentVMDB

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                               savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentPagamentBinding>(inflater,
            R.layout.fragment_pagament,container,false)

        pagament = ViewModelProvider(requireActivity()).get(PagamentVM::class.java)

        binding.nomUsuari.text = SharedApp.prefs.nomUsuari
        binding.ShowPrimerPLat.text = pagament.getNomBeguda()
        binding.ShowSegonPLat.text = pagament.getNomEntrepa()
        binding.ShowPostres.text = pagament.getNomPostre()


        var preuTotal = pagament.getPreuBeguda() + pagament.getPreuEntrepa() + pagament.getPreuPostre()

        val decimal = BigDecimal(preuTotal).setScale(2, RoundingMode.HALF_EVEN)

        binding.preutotal.text = decimal.toString()


        val application = requireNotNull(this.activity).application
        val dataSource = BlueBirdDatabase.getDatabase(application).bluebirdDao
        val viewModelFactory = PagamentVMFactory(dataSource, application)
        viewModel = ViewModelProvider(this, viewModelFactory).get(PagamentVMDB::class.java)

        binding.pagar.setOnClickListener(){ view : View ->
            if(pagament.correuUsuariLogIn.equals("")){
                Toast.makeText(application, "No ha iniciat sessio!", Toast.LENGTH_LONG).show()
                view.findNavController().navigate(R.id.action_pagament_to_welcome2)
            }
            else{
                viewModel.insertComanda(pagament.getCorreu(), pagament.getNomBeguda(), pagament.getNomEntrepa(), pagament.getNomPostre(), decimal.toDouble())
                Toast.makeText(application, "Comanda feta emb exit!", Toast.LENGTH_LONG).show()
            }

        }

        return binding.root
    }


}