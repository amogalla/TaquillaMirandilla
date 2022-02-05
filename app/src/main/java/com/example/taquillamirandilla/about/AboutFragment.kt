package com.example.taquillamirandilla.about

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.taquillamirandilla.R
import com.example.taquillamirandilla.databinding.FragmentAboutBinding


class aboutFragment : Fragment() {

    private val viewModel: AboutViewModel by lazy {
        ViewModelProvider(this).get(AboutViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentAboutBinding.inflate(inflater)
        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding.lifecycleOwner = this

        // Giving the binding access to the OverviewViewModel
        binding.viewModel = viewModel
        return inflater.inflate(R.layout.fragment_about, container, false)
    }


}