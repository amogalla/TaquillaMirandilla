package com.example.taquillamirandilla

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.taquillamirandilla.databinding.FragmentFourthBinding

private const val ARG_PARAM1 = "param1"

class FourthFragment : Fragment() {

    private var param1:String? = null
    private var _binding: FragmentFourthBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        arguments?.let{
            param1 = it.getString(ARG_PARAM1)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item!!.itemId) {
            R.id.share -> shareSuccess()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)  //Tiene UN menú
        // Inflamos el layout al crear la vista
        _binding = FragmentFourthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Como el pedido ya está realizado, al pulsar el botón Inicio,
        // volvemos al primer fragmento.
        binding.buttonFourth.setOnClickListener {
            findNavController().navigate(R.id.action_fourthFragment_to_FirstFragment)
        }
    }

    private fun getShareIntent() : Intent {
        //val args = FourthFragmentArgs.fromBundle(arguments)
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain")
            .putExtra(Intent.EXTRA_TEXT, getString(R.string.share_success_text))
        return shareIntent
    }

    private fun shareSuccess() {
        startActivity(getShareIntent())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.menu_main, menu)
        // check if the activity resolves
        if (null == getShareIntent().resolveActivity(requireActivity().packageManager)) {
            // hide the menu item if it doesn't resolve
            menu?.findItem(R.id.share)?.setVisible(false)
        }
    }

}