package com.example.bluebirdrestaurant.iniciSesio

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
import com.example.bluebirdrestaurant.databinding.ActivityMainBinding
import com.example.bluebirdrestaurant.databinding.FragmentWelcomeBinding
import com.example.bluebirdrestaurant.pagament.PagamentVM
import com.example.bluebirdrestaurant.registre.RegistreVM
import com.example.bluebirdrestaurant.registre.RegistreVMFactory


class Welcome : Fragment() {


    private lateinit var vModel : WelcomeVM
    private lateinit var pagament : PagamentVM

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentWelcomeBinding>(inflater,
            R.layout.fragment_welcome,container,false)


        val application = requireNotNull(this.activity).application
        val dataSource = BlueBirdDatabase.getDatabase(application).bluebirdDao
        val viewModelFactory = WelcomeVMFactory(dataSource, application)
        vModel = ViewModelProvider(this, viewModelFactory).get(WelcomeVM::class.java)
        pagament = ViewModelProvider(requireActivity()).get(PagamentVM::class.java)
        vModel.creacioDePlats()


        binding.logInButton.setOnClickListener { view : View ->

            if(vModel.comprobarUsuari(binding.emailUser.text.toString(), binding.passwordUser.text.toString())=="ok"){

                pagament.setCorreu(binding.emailUser.text.toString())
                view.findNavController().navigate(R.id.action_welcome2_to_inici)
            }

        }

        binding.singInButton.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_welcome2_to_registre)
        }
        return binding.root
    }

}