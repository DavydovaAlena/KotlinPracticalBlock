package ru.adavydova.practicalblockkotlin.task2

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.core.content.edit
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty



class AppStartupTimeDelegate(
    private val sharedPreferences: SharedPreferences
) {
    companion object {
        const val TIME_DELEGATE = "app_time_delegate"
    }

    var timeDelegate by sharedPreferences.delegate(TIME_DELEGATE, "")
}