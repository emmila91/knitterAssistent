package com.kkuznetsova.knitterassistent.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kkuznetsova.knitterassistent.models.Marker

class MainActivityViewModel : ViewModel() {
    private val _counterData = MutableLiveData(0)
    val counterData: LiveData<Int> = _counterData

    private val _marker = MutableLiveData<Marker?>(null)
    val marker: LiveData<Marker?> = _marker

    fun onAddClicked() {
        _counterData.value = _counterData.value?.plus(1)
    }

    fun onResetClicked() {
        _counterData.value = 0
        _marker.value = null
    }

    fun onAddMarkClicked(comment: String) {
        _marker.value = Marker(comment, _counterData.value ?: 0)
    }
}