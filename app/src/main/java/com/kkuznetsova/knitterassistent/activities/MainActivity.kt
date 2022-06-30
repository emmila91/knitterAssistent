package com.kkuznetsova.knitterassistent.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.kkuznetsova.knitterassistent.R
import com.kkuznetsova.knitterassistent.databinding.ActivityMainBinding
import com.kkuznetsova.knitterassistent.fragments.AddMarkerDialogFragment
import com.kkuznetsova.knitterassistent.viewmodels.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        activityMainBinding.viewModel = viewModel
        activityMainBinding.lifecycleOwner = this

        activityMainBinding.addButton.setOnClickListener {
            viewModel.onAddClicked()
        }

        activityMainBinding.resetButton.setOnClickListener {
            viewModel.onResetClicked()
        }

        activityMainBinding.addMarkButton.setOnClickListener {
            AddMarkerDialogFragment().show(supportFragmentManager, null)
        }
    }
}