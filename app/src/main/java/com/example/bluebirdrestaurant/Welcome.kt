package com.example.bluebirdrestaurant

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.bluebirdrestaurant.R
import com.example.bluebirdrestaurant.databinding.ActivityMainBinding
import com.example.bluebirdrestaurant.databinding.FragmentWelcomeBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private lateinit var binding: ActivityMainBinding

/**
 * A simple [Fragment] subclass.
 * Use the [Welcome.newInstance] factory method to
 * create an instance of this fragment.
 */
class Welcome : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentWelcomeBinding>(inflater,
            R.layout.fragment_welcome,container,false)

        binding.logInButton.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_welcome2_to_primerPlat)
        }

        binding.singInButton.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_welcome2_to_registre)
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
         * @return A new instance of fragment Welcome.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Welcome().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}