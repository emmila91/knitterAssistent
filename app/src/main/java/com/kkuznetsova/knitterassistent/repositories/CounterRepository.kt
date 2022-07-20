package com.kkuznetsova.knitterassistent.repositories

import android.content.Context

class CounterRepository(context: Context) : SharedPreferencesRepository(context) {
    companion object {
        const val PREF_COUNTER = "com.kkuznetsova.knitterassistent.PREF_COUNTER"
    }

    fun setCounter(value: Int) = PREF_COUNTER.put(value)

    fun getCounter(): Int {
        var counter = 0
        if (sharedPrefs.contains(PREF_COUNTER)) {
            counter = PREF_COUNTER.getInt()
        }
        return counter
    }
}