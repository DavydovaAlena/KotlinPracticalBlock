package ru.adavydova.practicalblockkotlin.task3

import androidx.compose.runtime.Immutable

@JvmInline
@Immutable
value class ListAnyValues(
    private val list: List<Any> = listOf("hello", 2.3f, "name", false, 2, true)
) : List<Any> by list