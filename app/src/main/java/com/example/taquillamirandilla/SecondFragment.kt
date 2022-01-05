package com.example.taquillamirandilla

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.taquillamirandilla.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!
    private var partido:String = "Test"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflamos el layout al crear la vista
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Al pulsar el botón, navegamos al tercer fragmento.

        binding.buttonPrimerPartido.setOnClickListener {
            val bundle = bundleOf("partido" to binding.textviewPrimerPartido.text)
            findNavController().navigate(R.id.action_SecondFragment_to_thirdFragment, bundle)
        }

        binding.buttonSegundoPartido.setOnClickListener {
            val bundle = bundleOf("partido" to binding.textviewSegundoPartido.text)
            findNavController().navigate(R.id.action_SecondFragment_to_thirdFragment, bundle)
        }

        binding.buttonTercerPartido.setOnClickListener {
            val bundle = bundleOf("partido" to binding.textviewTercerPartido.text)
            findNavController().navigate(R.id.action_SecondFragment_to_thirdFragment, bundle)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}