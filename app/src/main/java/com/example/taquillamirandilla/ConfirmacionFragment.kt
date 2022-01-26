package com.example.taquillamirandilla

import android.os.Bundle
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
import com.example.taquillamirandilla.databinding.FragmentConfirmacionBinding

val ARG_GRADA = "grada"



class ThirdFragment : Fragment() {

    private lateinit var viewModel:ConfirmacionViewModel
    private var partido:String? = null
    private var grada:String? = null
    private var _binding: FragmentConfirmacionBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        arguments?.let{
            partido = it.getString(ARG_PARTIDO)
            grada = it.getString(ARG_GRADA)
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)  //Tiene UN menú
        // Inflamos el layout al crear la vista
        _binding = FragmentConfirmacionBinding.inflate(inflater, container, false)
        binding.textviewNombrePartido.text = partido
        binding.textviewNombreGrada.text = grada
        viewModel = ViewModelProviders.of(this).get(ConfirmacionViewModel::class.java)

        binding.buttonThird.setOnClickListener{
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
        //Generamos un número aleatorio entre 1 y 2
        //val pago = (0 until 2).random()
        val pago = 1
        val bundle = bundleOf("param1" to "Pago autorizado: " + pago.toString())

        //Si el número aleatorio ha sido el 1, el pedido se ha realizado correctamente
        /*if(pago == 1) {
            binding.buttonThird.setOnClickListener {
                findNavController().navigate(R.id.action_thirdFragment_to_fourthFragment, bundle) //Navegamos al fragmento 4.
            }
        }else{ //Si el número aleatorio ha sido el 2, ha habido un error en el pago
            binding.buttonThird.setOnClickListener {
                findNavController().navigate(R.id.action_thirdFragment_to_fifthFragment, bundle) //Navegamos al fragmento 5.
            }
        }*/
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun actualizaTextoPartido(){
        binding.textViewConfirmacion1.text = viewModel.partido
    }


}