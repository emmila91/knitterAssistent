package com.kkuznetsova.knitterassistent.models

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kkuznetsova.knitterassistent.interfaces.SharedPrefs
import com.kkuznetsova.knitterassistent.repositories.MarkersDataRepository

class MarkersData(val context: Context) : SharedPrefs {
    private val markersDataRepository = MarkersDataRepository(context)
    private val _markers = MutableLiveData<List<Marker>>(emptyList())
    val markers: LiveData<List<Marker>> = _markers

    init {
        restoreFromSharedPrefs()
    }

    fun reset() {
        _markers.value = listOf()
    }

    fun addMarker(marker: Marker) {
        _markers.value = _markers.value?.plus(marker)
    }

    fun removeMarker(marker: Marker) {
        _markers.value = _markers.value?.minus(marker)
    }

    fun saveData() {
        saveToSharedPrefs()
    }

    override fun saveToSharedPrefs() {
        markersDataRepository.setMarkers(_markers?.value ?: listOf())
    }

    override fun restoreFromSharedPrefs() {
        _markers.value = markersDataRepository.getMarkers()
    }
}