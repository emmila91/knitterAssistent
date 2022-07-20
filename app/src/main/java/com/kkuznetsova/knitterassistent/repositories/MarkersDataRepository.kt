package com.kkuznetsova.knitterassistent.repositories

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.kkuznetsova.knitterassistent.models.Marker

class MarkersDataRepository(context: Context) : SharedPreferencesRepository(context) {
    companion object {
        const val PREF_MARKERS = "com.kkuznetsova.knitterassistent.PREF_MARKERS"
    }

    private val gson = Gson()

    fun setMarkers(markers: List<Marker>) {
        PREF_MARKERS.put(gson.toJson(markers))
    }

    fun getMarkers(): List<Marker> {
        var markers: List<Marker> = listOf()
        if (sharedPrefs.contains(PREF_MARKERS)) {
            val json = PREF_MARKERS.getString()
            val listMarkersType = object : TypeToken<List<Marker>>() {}.type
            markers = gson.fromJson(json, listMarkersType)
        }
        return markers
    }
}