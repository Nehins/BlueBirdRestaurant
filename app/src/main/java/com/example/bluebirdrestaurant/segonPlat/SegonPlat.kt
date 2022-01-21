package com.example.bluebirdrestaurant.segonPlat

import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bluebirdrestaurant.Adapter
import com.example.bluebirdrestaurant.R
import com.example.bluebirdrestaurant.data.BlueBirdDatabase
import com.example.bluebirdrestaurant.databinding.FragmentSegonPlatBinding
import com.example.bluebirdrestaurant.pagament.PagamentVM


class SegonPlat : Fragment() {
    lateinit var application : Application
    private lateinit var viewModel: SegonPlatVM
    private lateinit var pagament : PagamentVM

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentSegonPlatBinding>(inflater,
            R.layout.fragment_segon_plat,container,false)

        pagament = ViewModelProvider(requireActivity()).get(PagamentVM::class.java)
        application = requireNotNull(this.activity).application
        val dataSource = BlueBirdDatabase.getDatabase(application).bluebirdDao
        val viewModelFactory = SegonPlatVMFactory(dataSource, application)
        viewModel = ViewModelProvider(this, viewModelFactory).get(SegonPlatVM::class.java)
        val recyclerView: RecyclerView = binding.entrepanView

        // Specify layout for recycler view
        val linearLayoutManager = LinearLayoutManager(application, RecyclerView.VERTICAL,false)
        recyclerView.layoutManager = linearLayoutManager


            recyclerView.adapter = Adapter(application, viewModel.llistaSegons, pagament)


        return binding.root
    }

}