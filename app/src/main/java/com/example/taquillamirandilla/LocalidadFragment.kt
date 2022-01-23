package com.example.taquillamirandilla

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.taquillamirandilla.databinding.FragmentFirstBinding
import com.example.taquillamirandilla.databinding.FragmentLocalidadBinding


// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class LocalidadFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    private var _binding: FragmentLocalidadBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)  //Tiene UN menú
        // Inflamos el layout al crear la vista
        _binding = FragmentLocalidadBinding.inflate(inflater, container, false)
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
            findNavController().navigate(R.id.action_localidad_to_thirdFragment)
        }

        binding.buttonFondoNorte.setOnClickListener {
            findNavController().navigate(R.id.action_localidad_to_thirdFragment)
        }

        binding.buttonFondoSur.setOnClickListener {
            findNavController().navigate(R.id.action_localidad_to_thirdFragment)
        }

        binding.buttonPreferencia.setOnClickListener {
            findNavController().navigate(R.id.action_localidad_to_thirdFragment)
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
}