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

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class LocalidadFragment : Fragment() {
    private lateinit var viewModel:LocalidadViewModel
    private var partido:String? = null

    private var param1: String? = null
    private var param2: String? = null
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

        Log.i("LocalidadViewModel", "Providers call.")
        viewModel = ViewModelProviders.of(this).get(LocalidadViewModel::class.java)

        binding.buttonFondoNorte.setOnClickListener{
            actualizaTextoPartido()
        }


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
            val bundle = bundleOf("partido" to partido)
            findNavController().navigate(R.id.action_localidad_to_thirdFragment, bundle)
        }

        binding.buttonFondoNorte.setOnClickListener {
            val bundle = bundleOf("partido" to partido)
            //actualizaTextoPartido()
            findNavController().navigate(R.id.action_localidad_to_thirdFragment, bundle)
        }

        binding.buttonFondoSur.setOnClickListener {
            val bundle = bundleOf("partido" to partido)
            findNavController().navigate(R.id.action_localidad_to_thirdFragment, bundle)
        }

        binding.buttonPreferencia.setOnClickListener {
            val bundle = bundleOf("partido" to partido)
            findNavController().navigate(R.id.action_localidad_to_thirdFragment, bundle)
        }
    }
    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LocalidadFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }



    private fun actualizaTextoPartido(){
        binding.textviewFondoNorte.text = partido // viewModel.partido
    }



    fun localidadTermina() {
        findNavController().navigate(R.id.action_localidad_to_thirdFragment)
    }

}