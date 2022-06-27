package com.kkuznetsova.knitterassistent.viewmodels

import com.kkuznetsova.knitterassistent.models.CounterData

class MainActivityViewModel {
    private var counterData = CounterData()

    fun getCounterData() = counterData

    fun onAddClicked() = counterData.updateCounter()

    fun onResetClicked() {
        counterData.resetCounter()
    }
    fun onAddMarkClicked() {

    }
}