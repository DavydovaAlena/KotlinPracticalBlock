package ru.adavydova.practicalblockkotlin.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.adavydova.practicalblockkotlin.task2.AppStartupTimeDelegate
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(context: Application): SharedPreferences{
        return context.getSharedPreferences("APP_PREFS", Context.MODE_PRIVATE)

    }

    @Provides
    @Singleton
    fun provideAppStartupTimeDelegate(
        sharedPreferences: SharedPreferences): AppStartupTimeDelegate {
        return AppStartupTimeDelegate(sharedPreferences)
    }


}