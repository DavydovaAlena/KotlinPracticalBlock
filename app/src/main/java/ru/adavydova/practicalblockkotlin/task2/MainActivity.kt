package ru.adavydova.practicalblockkotlin.task2

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import dagger.hilt.android.AndroidEntryPoint
import ru.adavydova.practicalblockkotlin.ui.theme.PracticalBlockKotlinTheme
import java.util.Calendar
import java.util.Locale
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var startupTimeDelegate: AppStartupTimeDelegate
    private var logBinder: LogService.LogBinder? = null


    private val serviceConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            logBinder = service as LogService.LogBinder
            logBinder?.startLogger(startupTimeDelegate.timeDelegate)

        }

        override fun onServiceDisconnected(name: ComponentName?) {
            logBinder?.stopLogger()
        }
    }

    override fun onStart() {
        super.onStart()
        bindService(
            Intent(this@MainActivity, LogService::class.java),
            serviceConnection,
            BIND_AUTO_CREATE
        )
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            val time = Calendar.getInstance(Locale("ru")).time
            startupTimeDelegate.timeDelegate = time.toString()
        }

        setContent {
            PracticalBlockKotlinTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }


    override fun onStop() {
        super.onStop()
        logBinder?.stopLogger()
        unbindService(serviceConnection)
    }

}