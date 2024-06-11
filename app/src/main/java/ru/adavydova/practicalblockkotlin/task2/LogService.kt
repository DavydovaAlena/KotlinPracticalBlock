package ru.adavydova.practicalblockkotlin.task2

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LogService : Service() {

    private val scope = CoroutineScope(Dispatchers.Default)
    private var isWork = false

    inner class LogBinder : Binder() {
        fun startLogger(message: String) {
            isWork = true
            runLogger(message)
        }

        fun stopLogger() {
            isWork = false
        }
    }

    override fun onBind(intent: Intent?): IBinder? {
        return LogBinder()
    }



    private fun runLogger(message: String) {
        scope.launch {
            while (isWork) {
                Log.d("LogService", "$message (${Thread.currentThread().name})")
                delay(3000)
            }
        }
    }

}