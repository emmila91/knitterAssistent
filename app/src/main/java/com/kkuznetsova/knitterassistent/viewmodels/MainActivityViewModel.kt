package com.kkuznetsova.knitterassistent.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kkuznetsova.knitterassistent.models.Marker

class MainActivityViewModel : ViewModel() {
    private val _counterData = MutableLiveData(0)
    val counterData: LiveData<Int> = _counterData

    private val _marker = MutableLiveData<List<Marker>>(emptyList())
    val marker: LiveData<List<Marker>> = _marker

    fun onAddClicked() {
        _counterData.value = _counterData.value?.plus(1)
    }

    fun onResetClicked() {
        _counterData.value = 0
        _marker.value = listOf()
    }

    fun onAddMarkClicked(comment: String) {
        _marker.value = _marker.value?.plus(Marker(comment, _counterData.value ?: 0))
    }

    fun onRemoveMarkerClicked(marker: Marker) {
        _marker.value = _marker.value?.minus(marker)
    }
}