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
import com.example.taquillamirandilla.databinding.FragmentThirdBinding

val ARG_PARTIDO = "partido"

class ThirdFragment : Fragment() {

    private var partido:String? = null
    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        arguments?.let{
            partido = it.getString(ARG_PARTIDO)
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)  //Tiene UN menú
        // Inflamos el layout al crear la vista
        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        binding.textviewNombrePartido.text = partido
        return binding.root
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Generamos un número aleatorio entre 1 y 2
        val pago = (0 until 2).random()

        val bundle = bundleOf("param1" to "Pago autorizado: " + pago.toString())

        //Si el número aleatorio ha sido el 1, el pedido se ha realizado correctamente
        if(pago == 1) {
            binding.buttonThird.setOnClickListener {
                findNavController().navigate(R.id.action_thirdFragment_to_fourthFragment, bundle) //Navegamos al fragmento 4.
            }
        }else{ //Si el número aleatorio ha sido el 2, ha habido un error en el pago
            binding.buttonThird.setOnClickListener {
                findNavController().navigate(R.id.action_thirdFragment_to_fifthFragment, bundle) //Navegamos al fragmento 5.
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}