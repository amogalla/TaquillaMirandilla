package com.example.taquillamirandilla

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.taquillamirandilla.databinding.FragmentFirstBinding
import com.example.taquillamirandilla.databinding.FragmentLocalidadBinding


val ARG_PARTIDO = "partido"

class LocalidadFragment : Fragment() {
    //private lateinit var viewModel:ConfirmacionViewModel
    private var partido:String? = null

    private var _binding: FragmentLocalidadBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            partido = it.getString(ARG_PARTIDO)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)  //Tiene UN menú
        // Inflamos el layout al crear la vista
        _binding = FragmentLocalidadBinding.inflate(inflater, container, false)

        Log.i("ConfirmacionViewModel", "Providers call.")
        //viewModel = ViewModelProviders.of(this).get(ConfirmacionViewModel::class.java)


        return binding.root
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Al pulsar el botón, navegamos al siguiente fragmento.
        binding.buttonTribuna.setOnClickListener {
            val bundle = bundleOf("partido" to partido, "grada" to binding.textviewTribuna.text)
            findNavController().navigate(R.id.action_localidad_to_thirdFragment, bundle)
        }

        binding.buttonFondoNorte.setOnClickListener {
            val bundle = bundleOf("partido" to partido, "grada" to binding.textviewFondoNorte.text)
            //actualizaTextoPartido()
            findNavController().navigate(R.id.action_localidad_to_thirdFragment, bundle)
        }

        binding.buttonFondoSur.setOnClickListener {
            val bundle = bundleOf("partido" to partido,  "grada" to binding.textviewFondoSur.text)
            findNavController().navigate(R.id.action_localidad_to_thirdFragment, bundle)
        }

        binding.buttonPreferencia.setOnClickListener {
            val bundle = bundleOf("partido" to partido,  "grada" to binding.textviewPreferencia.text)
            findNavController().navigate(R.id.action_localidad_to_thirdFragment, bundle)
        }
    }
    companion object {

        @JvmStatic
        fun newInstance(param1: String) =
            LocalidadFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARTIDO, param1)
                }
            }
    }





    fun localidadTermina() {
        findNavController().navigate(R.id.action_localidad_to_thirdFragment)
    }

}