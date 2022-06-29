package com.kkuznetsova.knitterassistent.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kkuznetsova.knitterassistent.models.CounterData

class MainActivityViewModel : ViewModel() {
    private val _counterData = MutableLiveData(CounterData())
    val counterData: LiveData<CounterData> = _counterData

    fun onAddClicked() {
        _counterData.value?.updateCounter()
    }

    fun onResetClicked() {
        _counterData.value?.resetCounter()
    }

    fun onAddMarkClicked() {

    }
}