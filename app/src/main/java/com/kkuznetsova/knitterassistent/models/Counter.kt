package com.kkuznetsova.knitterassistent.models

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kkuznetsova.knitterassistent.interfaces.SharedPrefs
import com.kkuznetsova.knitterassistent.repositories.CounterRepository

class Counter(context: Context) : SharedPrefs {
    private val counterRepository = CounterRepository(context)
    private val _counterData = MutableLiveData(0)
    val counterData: LiveData<Int> = _counterData

    init {
        restoreFromSharedPrefs()
    }

    fun reset() {
        setValue(0)
    }

    fun addCount() {
        setValue(_counterData.value?.plus(1) ?: 0)
    }

    fun saveData() {
        saveToSharedPrefs()
    }

    private fun setValue(value: Int) {
        _counterData.value = value
    }

    override fun saveToSharedPrefs() {
        counterRepository.setCounter(_counterData.value ?: 0)
    }

    override fun restoreFromSharedPrefs() {
        _counterData.value = counterRepository.getCounter()
    }
}