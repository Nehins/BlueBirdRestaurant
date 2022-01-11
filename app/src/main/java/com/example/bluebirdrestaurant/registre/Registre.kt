package com.example.bluebirdrestaurant.registre

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
import com.example.bluebirdrestaurant.data.BlueBirdDatabase
import com.example.bluebirdrestaurant.databinding.FragmentRegistreBinding


class Registre : Fragment() {

    private lateinit var viewModel : RegistreVM

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<FragmentRegistreBinding>(
            inflater, R.layout.fragment_registre, container, false)

        val application = requireNotNull(this.activity).application
        val dataSource = BlueBirdDatabase.getDatabase(application).bluebirdDao
        val viewModelFactory = RegistreVMFactory(dataSource, application)
        viewModel = ViewModelProvider(this, viewModelFactory).get(RegistreVM::class.java)

        binding.setLifecycleOwner(this)
        binding.viewModel= viewModel
        binding.buttonReg.setOnClickListener(){ view : View ->
            if(binding.contrasenya.text.toString().equals(binding.verificarContrasenya.text.toString())){
                viewModel.insertNouUsuari(binding.nom.text.toString(), binding.Correu.text.toString(), binding.contrasenya.text.toString())
                view.findNavController().navigate(R.id.action_registre_to_welcome2)
            }

            else{
                Toast.makeText(application, "Error! Comrpoba les contrasenyes", Toast.LENGTH_LONG).show()
            }
        }

        return binding.root
    }
}



