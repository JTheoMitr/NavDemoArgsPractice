package com.example.navdemoargspractice

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.navdemoargspractice.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // set name variable with incoming argument data from bundle (which can be empty so it's a nullable)
        val name = arguments?.getString("name")

        // we will do the same for the mobile number
        val mobileNumber = arguments?.getLong("mobile")



        _binding = FragmentSecondBinding.inflate(inflater, container, false)

        // Log.d("bundle", "name is $name and mobile is $mobileNumber")
        // AFTER declaring _binding you can bind the incoming data to the appropriate view:

        binding.tvName.text = name
        binding.tvMobileNumber.text = mobileNumber.toString()

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//          simple button method to navigate to FirstFragment
//        binding.buttonSecond.setOnClickListener {
//            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
//        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}