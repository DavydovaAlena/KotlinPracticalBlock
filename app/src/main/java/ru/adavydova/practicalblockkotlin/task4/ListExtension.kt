package ru.adavydova.practicalblockkotlin.task4

fun MutableList<Int?>.shakerSorted(): List<Int?> {

    var swapped = false

    fun swap(i: Int) {

        val currentValue = this[i]
        val nextValue = this[i+1] ?: return

        if (currentValue == null ||  currentValue > nextValue) {
            this[i] = nextValue
            this[i + 1] = currentValue
            swapped = true
        }
    }
    do {
        for (i in 0 until size - 1) {
            swap(i)
        }
        if (!swapped) break
        swapped = false

        for (i in size - 2 downTo 0) {
            swap(i)
        }
    } while (swapped)

    return this
}
