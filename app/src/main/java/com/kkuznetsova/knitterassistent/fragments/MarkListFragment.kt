package com.kkuznetsova.knitterassistent.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.kkuznetsova.knitterassistent.R
import com.kkuznetsova.knitterassistent.databinding.FragmentMarkListBinding
import com.kkuznetsova.knitterassistent.viewmodels.MainActivityViewModel

class MarkListFragment : Fragment() {

    private val viewModel: MainActivityViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentMarkListBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_mark_list,
            container,
            false
        )

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        return binding.root
    }
}