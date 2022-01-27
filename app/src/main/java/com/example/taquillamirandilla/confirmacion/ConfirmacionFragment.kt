package com.example.taquillamirandilla.confirmacion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.taquillamirandilla.ARG_PARTIDO
import com.example.taquillamirandilla.R
import com.example.taquillamirandilla.databinding.FragmentConfirmacionBinding

val ARG_GRADA = "grada"


class ConfirmacionFragment : Fragment() {

    private lateinit var viewModel:ConfirmacionViewModel
    private lateinit var viewModelFactory:ConfirmacionViewModelFactory

    private var codigo:String? = ""
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
        _binding = FragmentConfirmacionBinding.inflate(inflater, container, false)

        //Establecemos el valor de los textViews que nos llegan como parámetros de los fragmentos anteriores
        binding.textviewNombrePartido.text = partido
        binding.textviewNombreGrada.text = grada

        //Invisibilizamos los dos textos referentes al código de compra
        binding.textViewInfoCodigo.isVisible = false
        binding.textViewCodigo.isVisible = false

        viewModelFactory = ConfirmacionViewModelFactory(partido!!, grada!!, codigo!!) //Sabemos al 100% que ni el partido ni la grada pueden ser null
        viewModel = ViewModelProvider(this, viewModelFactory).get(ConfirmacionViewModel::class.java)

        codigo = viewModel.resetList().toString()

        binding.buttonValidarCompra.setOnClickListener{
            viewModel.resetList()
            binding.textViewInfoCodigo.isVisible = true
            binding.textViewCodigo.isVisible = true
            binding.buttonSiguiente.isEnabled = true
            binding.buttonValidarCompra.isEnabled = false
        }

        viewModel.codigoEntrada.observe(this, Observer { nuevoCodigoEntrada ->
            binding.textViewCodigo.text = nuevoCodigoEntrada.toString()
        })

        return binding.root
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Generamos un número aleatorio entre 1 y 2
        //val pago = (0 until 2).random()
        val pago = 0
        val bundle = bundleOf("param1" to "Pago autorizado: " + pago.toString())

        //Si el número aleatorio ha sido el 1, el pedido se ha realizado correctamente
        if(pago == 1) {
            binding.buttonSiguiente.setOnClickListener {
                findNavController().navigate(R.id.action_thirdFragment_to_fourthFragment, bundle) //Navegamos al fragmento 4.
            }
        }else{ //Si el número aleatorio ha sido el 2, ha habido un error en el pago
            binding.buttonSiguiente.setOnClickListener {
                findNavController().navigate(R.id.action_thirdFragment_to_fifthFragment, bundle) //Navegamos al fragmento 5.
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}