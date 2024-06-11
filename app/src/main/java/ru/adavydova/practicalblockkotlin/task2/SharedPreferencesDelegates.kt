package ru.adavydova.practicalblockkotlin.task2

import android.content.SharedPreferences
import android.util.Log
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty


inline fun<reified T> SharedPreferences.delegate(
    name: String,
    defValue: T
) = object : ReadWriteProperty<Any, T> {
    override fun getValue(thisRef: Any, property: KProperty<*>): T {
        return when(defValue){
            is Boolean -> (getBoolean(name, defValue) as? T)?: defValue
            is Long -> (getLong(name, defValue) as? T)?: defValue
            is Int -> (getInt(name, defValue) as? T)?: defValue
            is Float -> (getFloat(name, defValue) as? T)?: defValue
            is String ->  getString(name, defValue) as? T ?: defValue
            else -> throw IllegalArgumentException()
        }
    }
    override fun setValue(thisRef: Any, property: KProperty<*>, value: T) {
        with(edit()) {
            when (value) {
                is Boolean -> putBoolean(name, value)
                is Long -> putLong(name, value)
                is Int -> putInt(name, value)
                is Float -> putFloat(name, value)
                is String -> {
                    putString(name, value)
                    Log.d("get", getString(name, "").toString())
                }
                else -> throw IllegalArgumentException()
            }
            apply()
        }
    }
}