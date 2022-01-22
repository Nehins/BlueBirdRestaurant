package com.example.bluebirdrestaurant.inci

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bluebirdrestaurant.R
import com.example.bluebirdrestaurant.comandesUsuari.ComandaUsuariAdapter
import com.example.bluebirdrestaurant.comandesUsuari.ComandaUsuariVM
import com.example.bluebirdrestaurant.comandesUsuari.ComandaUsuariVMFactory
import com.example.bluebirdrestaurant.data.BlueBirdDatabase
import com.example.bluebirdrestaurant.databinding.FragmentComandaUsuariBinding
import com.example.bluebirdrestaurant.databinding.FragmentIniciBinding
import com.example.bluebirdrestaurant.pagament.PagamentVM

class inici : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentIniciBinding>(inflater,
            R.layout.fragment_inici,container,false)

        binding.ferComanda.setOnClickListener { view : View ->
                view.findNavController().navigate(R.id.action_inici_to_begudes)

        }

        return binding.root
    }
}