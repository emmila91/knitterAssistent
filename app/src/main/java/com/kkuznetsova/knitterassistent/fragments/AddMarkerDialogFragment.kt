package com.kkuznetsova.knitterassistent.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.kkuznetsova.knitterassistent.R
import com.kkuznetsova.knitterassistent.databinding.FragmentAddMarkerDialogBinding
import com.kkuznetsova.knitterassistent.viewmodels.MainActivityViewModel

class AddMarkerDialogFragment : DialogFragment() {
    val viewModel: MainActivityViewModel by activityViewModels()
    private lateinit var binding: FragmentAddMarkerDialogBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_add_marker_dialog,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListeners()
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
    }

    private fun setupClickListeners() {
        binding.positiveButton.setOnClickListener {
            viewModel.onAddMarkClicked(
                if (binding.dialogEditText.editableText.isNotEmpty())
                    binding.dialogEditText.editableText.toString()
                else {
                    getString(R.string.new_marker_title)
                }
            )
            dismiss()
        }

        binding.negativeButton.setOnClickListener {
            dismiss()
        }
    }
}