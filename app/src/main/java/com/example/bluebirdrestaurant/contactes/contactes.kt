package com.example.bluebirdrestaurant.contactes

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.bluebirdrestaurant.R
import com.example.bluebirdrestaurant.databinding.FragmentContactesBinding


class contactes : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentContactesBinding>(inflater,
            R.layout.fragment_contactes,container,false)
        binding.telefon.setOnClickListener{
            val intent = Intent(Intent.ACTION_DIAL)
            intent.setData(Uri.parse("tel:"+binding.telefon.text.toString()))
            startActivity(intent)
        }

        binding.correu.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setType("message/rfc822")
            intent.setData(Uri.parse("mailto:"+binding.correu.text.toString()))
            startActivity(intent)
        }



        return binding.root
    }

}