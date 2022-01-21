package com.example.bluebirdrestaurant.primerPlat

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bluebirdrestaurant.Adapter
import com.example.bluebirdrestaurant.R
import com.example.bluebirdrestaurant.data.BlueBirdDatabase
import com.example.bluebirdrestaurant.databinding.FragmentBegudesBinding
import com.example.bluebirdrestaurant.pagament.PagamentVM


class PrimerPlat : Fragment() {

    lateinit var application : Application
    private lateinit var viewModel: BegudesVM
    private lateinit var pagament : PagamentVM

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentBegudesBinding>(inflater,
            R.layout.fragment_begudes,container,false)


        pagament = ViewModelProvider(requireActivity()).get(PagamentVM::class.java)
        application = requireNotNull(this.activity).application
        val dataSource = BlueBirdDatabase.getDatabase(application).bluebirdDao
        val viewModelFactory = BegudesVMFactory(dataSource, application)
        viewModel = ViewModelProvider(this, viewModelFactory).get(BegudesVM::class.java)
        val recyclerView: RecyclerView = binding.begudesView

        val linearLayoutManager = LinearLayoutManager(application, RecyclerView.VERTICAL,false)
        recyclerView.layoutManager = linearLayoutManager

        recyclerView.adapter = Adapter(application, viewModel.llistaBegudes, pagament)

        return binding.root
    }


}