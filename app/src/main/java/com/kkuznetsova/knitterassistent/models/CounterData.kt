package com.kkuznetsova.knitterassistent.models

class CounterData(
    var counter: Int = 0,
    var isPlural: Boolean = true
) {
    fun updateCounter() {
        counter++
        isPlural = isCounterPlural()
    }

    fun resetCounter() {
        counter = 0
        isPlural = true
    }

    private fun isCounterPlural() = counter != 1
}
