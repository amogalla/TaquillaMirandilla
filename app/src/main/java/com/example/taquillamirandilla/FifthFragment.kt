package com.example.taquillamirandilla

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
import com.example.taquillamirandilla.confirmacion.ARG_GRADA
import com.example.taquillamirandilla.databinding.FragmentConfirmacionBinding
import com.example.taquillamirandilla.databinding.FragmentFifthBinding


val ARG_CODIGO = "codigo"

class FifthFragment : Fragment() {

    private var _binding: FragmentFifthBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(true)  //Tiene UN menú
        // Inflamos el layout al crear la vista
        _binding = FragmentFifthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Como el pago ha fallado, al pulsar el botón de reintentar
        // volvemos al tercer fragmento para intentar el pago de nuevo.
        /*
        binding.buttonFifth.setOnClickListener {
            findNavController().navigate(R.id.action_fifthFragment_to_confirmacionFragment)
        }
         */
    }
}