package com.example.navdemoargspractice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.navdemoargspractice.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnVerifyDetails.setOnClickListener {

            val firstName = binding.etFirstName.text.toString()
            val mobile = binding.etMobile.text.toString()

            when {
                firstName.isEmpty() -> {
                    Toast.makeText(activity, "Enter Name.", Toast.LENGTH_LONG).show()
                }
                mobile.isEmpty() -> {
                    Toast.makeText(activity, "Enter Mobile Number.", Toast.LENGTH_LONG).show()
                }
                else -> {
                    val bundle = bundleOf(
                        "name" to firstName,
                        "mobile" to mobile.toLong()
                    )
                    findNavController().navigate(
                        R.id.action_FirstFragment_to_SecondFragment,
                        bundle
                    )
                }
            }


        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}