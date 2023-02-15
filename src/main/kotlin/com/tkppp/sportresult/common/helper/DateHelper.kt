package com.tkppp.sportresult.common.helper

import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

val ON_TIME: LocalTime = LocalTime.of(0, 0)

fun LocalDateTime.toKorDateString(sep: String = "-", left: String = "", right: String = ""): String {
    return "${this.toDateString(sep)} ${getKorDayOfWeek(this, left, right)}"
}

fun LocalDateTime.toDateString(sep: String = "-"): String {
    val monthStr = if (monthValue < 10) "0$monthValue" else "$monthValue"
    val dayStr = if (dayOfMonth < 10) "0$dayOfMonth" else "$dayOfMonth"
    return listOf(year, monthStr, dayStr).joinToString(sep)
}

fun LocalDateTime.toTimeString(sep: String = ":"): String {
    val hourStr = if (hour < 10) "0$hour" else "$hour"
    val minStr = if (minute < 10) "0$minute" else "$minute"
    return listOf(hourStr, minStr).joinToString(sep)
}

fun getWeekStartAndEndDatetime(date: LocalDate = LocalDate.now()): Pair<LocalDateTime, LocalDateTime> {
    val korDayOfWeek = when(val dayOfWeek = date.dayOfWeek) {
        DayOfWeek.SUNDAY -> 6
        else -> dayOfWeek.value - 1
    }
    val start = date.minusDays(korDayOfWeek.toLong())
    val end = start.plusDays(7)
    return LocalDateTime.of(start, ON_TIME) to LocalDateTime.of(end, ON_TIME)
}

fun getMonthStartAndEndDatetime(year: Int, month: Int): Pair<LocalDateTime, LocalDateTime> {
    val start = LocalDate.of(year, month, 1)
    val end = start.plusMonths(1)
    return LocalDateTime.of(start, ON_TIME) to LocalDateTime.of(end, ON_TIME)
}

fun getKorDayOfWeek(date: LocalDateTime, left: String = "", right: String = ""): String {
    val korDayOfWeek = when(date.dayOfWeek) {
        DayOfWeek.SUNDAY -> "일"
        DayOfWeek.MONDAY -> "월"
        DayOfWeek.TUESDAY -> "화"
        DayOfWeek.WEDNESDAY -> "수"
        DayOfWeek.THURSDAY -> "목"
        DayOfWeek.FRIDAY -> "금"
        DayOfWeek.SATURDAY -> "토"
    }
    return "$left$korDayOfWeek$right"
}