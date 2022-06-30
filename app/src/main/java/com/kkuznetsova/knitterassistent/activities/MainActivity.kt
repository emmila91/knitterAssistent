package com.kkuznetsova.knitterassistent.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.kkuznetsova.knitterassistent.R
import com.kkuznetsova.knitterassistent.databinding.ActivityMainBinding
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
            viewModel.onAddMarkClicked("Comment")
        }
    }

    private fun updateCounter(counter: Int?) {
        activityMainBinding.counterTextView.text = counter.toString()
        activityMainBinding.rowsTextView.text = if (counter != 1) "rows" else "row"
    }
}