package com.kkuznetsova.knitterassistent.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.kkuznetsova.knitterassistent.models.Counter
import com.kkuznetsova.knitterassistent.models.Marker
import com.kkuznetsova.knitterassistent.models.MarkersData

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {
    private val context by lazy { application.applicationContext }
    val counter = Counter(context)
    val markersData = MarkersData(context)

    fun onAddClicked() {
        counter.addCount()
    }

    fun onResetClicked() {
        counter.reset()
        markersData.reset()
    }

    fun onAddMarkClicked(comment: String) {
        markersData.addMarker(Marker(comment, counter.counterData.value ?: 0))
    }

    fun onRemoveMarkerClicked(marker: Marker) {
        markersData.removeMarker(marker)
    }

    fun saveData() {
        counter.saveData()
        markersData.saveData()
    }
}