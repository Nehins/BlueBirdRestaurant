package com.example.bluebirdrestaurant.comandesUsuari

import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bluebirdrestaurant.R
import com.example.bluebirdrestaurant.data.BlueBirdDatabase
import com.example.bluebirdrestaurant.databinding.FragmentComandaUsuariBinding
import com.example.bluebirdrestaurant.pagament.PagamentVM


class ComandaUsuari : Fragment() {


    lateinit var application : Application
    private lateinit var viewModel: ComandaUsuariVM
    private lateinit var pagament : PagamentVM

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentComandaUsuariBinding>(inflater,
            R.layout.fragment_comanda_usuari,container,false)

        pagament = ViewModelProvider(requireActivity()).get(PagamentVM::class.java)
        application = requireNotNull(this.activity).application
        val dataSource = BlueBirdDatabase.getDatabase(application).bluebirdDao
        val viewModelFactory = ComandaUsuariVMFactory(dataSource, application)
        viewModel = ViewModelProvider(this, viewModelFactory).get(ComandaUsuariVM::class.java)
        val recyclerView: RecyclerView = binding.comandaView

        val linearLayoutManager = LinearLayoutManager(application, RecyclerView.VERTICAL,false)
        recyclerView.layoutManager = linearLayoutManager

        recyclerView.adapter = ComandaUsuariAdapter(application, viewModel.mostrarComandes(pagament.getCorreu()))

        return binding.root
    }
}