package com.kkuznetsova.knitterassistent.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.kkuznetsova.knitterassistent.R
import com.kkuznetsova.knitterassistent.databinding.ActivityMainBinding
import com.kkuznetsova.knitterassistent.models.CounterData
import com.kkuznetsova.knitterassistent.viewmodels.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        viewModel.counterData.observe(this) {
            updateCounter(it)
        }

        activityMainBinding.addButton.setOnClickListener {
            viewModel.onAddClicked()
            updateCounter(viewModel.counterData.value)
        }

        activityMainBinding.resetButton.setOnClickListener {
            viewModel.onResetClicked()
            updateCounter(viewModel.counterData.value)
        }

        activityMainBinding.addMarkButton.setOnClickListener {
            viewModel.onAddMarkClicked()
        }
    }

    private fun updateCounter(counterData: CounterData?) {
        activityMainBinding.counterTextView.text = (counterData?.counter ?: 0).toString()
        activityMainBinding.rowsTextView.text = if (counterData?.isPlural != false) "rows" else "row"
    }
}