package com.example.taquillamirandilla

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.taquillamirandilla.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!


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
            findNavController().navigate(R.id.action_SecondFragment_to_thirdFragment)
        }

        binding.buttonSegundoPartido.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_thirdFragment)
        }

        binding.buttonTercerPartido.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_thirdFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}