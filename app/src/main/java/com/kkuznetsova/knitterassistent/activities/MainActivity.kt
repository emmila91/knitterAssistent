package com.kkuznetsova.knitterassistent.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.kkuznetsova.knitterassistent.R
import com.kkuznetsova.knitterassistent.models.CounterData
import com.kkuznetsova.knitterassistent.viewmodels.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    lateinit var counter: TextView
    lateinit var rowText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addButton = findViewById<Button>(R.id.add_button)
        val resetButton = findViewById<Button>(R.id.reset_button)
        val addMarkButton = findViewById<Button>(R.id.add_mark_button)
        val markFragment = findViewById<View>(R.id.marks_list_fragment)

        counter = findViewById(R.id.counter_text_view)
        rowText = findViewById(R.id.rows_text_view)

        val viewModel = MainActivityViewModel()
        updateCounter(viewModel.getCounterData())

        addButton.setOnClickListener {
            viewModel.onAddClicked()
            updateCounter(viewModel.getCounterData())
        }

        resetButton.setOnClickListener {
            viewModel.onResetClicked()
            updateCounter(viewModel.getCounterData())
        }

        addMarkButton.setOnClickListener {
            viewModel.onAddMarkClicked()
        }
    }

    private fun updateCounter(counterData: CounterData) {
        counter.text = counterData.counter.toString()
        rowText.text = if (counterData.isPlural) "rows" else "row"
    }
}