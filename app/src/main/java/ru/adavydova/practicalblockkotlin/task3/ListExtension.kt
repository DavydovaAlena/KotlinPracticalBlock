package ru.adavydova.practicalblockkotlin.task3

inline fun <E,reified T> List<E>.findCertainTypeValueOrNull(): T? {
    forEach {
        if (it is T) return it
    }
    return null
}