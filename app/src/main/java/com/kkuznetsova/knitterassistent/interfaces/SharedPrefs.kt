package com.kkuznetsova.knitterassistent.interfaces

interface SharedPrefs {
    fun saveToSharedPrefs()
    fun restoreFromSharedPrefs()
}