package lumina.utils

import lumina.modals.Day
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.*

fun getDaysInMonth(year: Int, month: Int): List<Day> {
    val daysInMonth = mutableListOf<Day>()
    val totalDays = LocalDate.of(year, month, 1).month.length(LocalDate.of(year, month, 1).isLeapYear)
    for (day in 1..totalDays) {
        val date = LocalDate.of(year, month, day)
        val weekday = date.dayOfWeek.getDisplayName(TextStyle.FULL, Locale.ENGLISH)
        daysInMonth.add(Day(day, weekday))
    }
    return daysInMonth
}