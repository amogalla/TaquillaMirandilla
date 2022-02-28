package com.example.taquillamirandilla.partido

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.taquillamirandilla.R
import com.example.taquillamirandilla.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!
    private var partido:String = "Test"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(true)  //Tiene UN menú
        // Inflamos el layout al crear la vista
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Al pulsar el botón, navegamos al tercer fragmento.

        binding.buttonPrimerPartido.setOnClickListener {
            val bundle = bundleOf("partido" to binding.textviewPrimerPartido.text)
            findNavController().navigate(R.id.action_SecondFragment_to_localidadFragment, bundle)
        }

        binding.buttonSegundoPartido.setOnClickListener {
            val bundle = bundleOf("partido" to binding.textviewSegundoPartido.text)
            findNavController().navigate(R.id.action_SecondFragment_to_localidadFragment, bundle)
        }

        binding.buttonTercerPartido.setOnClickListener {
            val bundle = bundleOf("partido" to binding.textviewTercerPartido.text)
            findNavController().navigate(R.id.action_SecondFragment_to_localidadFragment, bundle)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}