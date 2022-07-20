package com.kkuznetsova.knitterassistent.repositories

import android.content.Context
import android.content.SharedPreferences

open class SharedPreferencesRepository(context: Context) {
    companion object {
        const val PREFERENCE_NAME = "com.kkuznetsova.knitterassistent.PREFERENCE_NAME"
    }

    protected val sharedPrefs: SharedPreferences =
        context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
    private val editor = sharedPrefs.edit()

    protected fun String.put(string: String) {
        editor.putString(this, string)
        editor.commit()
    }

    protected fun String.put(int: Int) {
        editor.putInt(this, int)
        editor.commit()
    }

    protected fun String.getInt() = sharedPrefs.getInt(this, 0)
    protected fun String.getString() = sharedPrefs.getString(this, "")!!
}