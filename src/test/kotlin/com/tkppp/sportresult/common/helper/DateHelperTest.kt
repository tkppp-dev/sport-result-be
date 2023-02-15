package com.tkppp.sportresult.common.helper

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.DisplayName
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

internal class DateHelperTest {

    @Test
    @DisplayName("날짜를 포맷팅한 결과가 반환되어야 한다")
    fun toDateStringTest() {
        val date = LocalDateTime.of(LocalDate.of(2023, 1, 2), ON_TIME)
        val separator = "/"

        // when
        val result = date.toDateString(separator)

        // then
        assertThat(result).isEqualTo("2023/01/02")
    }

    @Test
    @DisplayName("시간을 포맷팅한 결과가 반환되어야 한다")
    fun toTimeStringTest() {
        val time = LocalTime.of(18, 0)
        val date = LocalDateTime.of(LocalDate.of(2023, 1, 2), time)
        val separator = ":"

        // when
        val result = date.toTimeString(separator)

        // then
        assertThat(result).isEqualTo("18:00")
    }

    @Test
    @DisplayName("날짜와 한국 요일을 담은 문자열이 반환되어야 한다")
    fun toKorDateStringTest() {
        val date = LocalDateTime.of(LocalDate.of(2023, 1, 2), ON_TIME)
        val separator = "/"
        val (left, right) = "(" to ")"

        // when
        val result = date.toKorDateString(separator, left, right)

        // then
        assertThat(result).isEqualTo("2023/01/02 ${left}월$right")
    }

    @Test
    @DisplayName("그 주의 월요일, 다음 주의 월요일이 반환되어야 한다")
    fun getWeekStartAndEndDatetimeTest() {
        // given
        val now = LocalDate.of(2023, 1, 20)

        // when
        val result = getWeekStartAndEndDatetime(now)

        // then
        assertThat(result.first).isEqualTo(LocalDateTime.of(2023, 1, 16, 0, 0))
        assertThat(result.second).isEqualTo(LocalDateTime.of(2023, 1, 23, 0, 0))
    }

    @Test
    @DisplayName("그 달의 1일, 다음 달의 1일이 반환되어야 한다")
    fun getMonthStartAndEndDatetimeTest() {
        // given
        val (year, month) = 2023 to 1

        // when
        val result = getMonthStartAndEndDatetime(year, month)

        // then
        assertThat(result.first).isEqualTo(LocalDateTime.of(2023, 1, 1, 0, 0))
        assertThat(result.second).isEqualTo(LocalDateTime.of(2023, 2, 1, 0, 0))
    }

    @Test
    @DisplayName("한국어 요일이 반환되어야 한다")
    fun getKorDayOfWeekTest() {
        // given
        val sunday = LocalDateTime.of(LocalDate.of(2023, 1, 22), ON_TIME)
        val dates = (0..6).map { sunday.plusDays(it.toLong()) }
        val (left, right) = "(" to ")"
        val expects = listOf("일", "월", "화", "수", "목", "금", "토").map { "$left$it$right" }

        // when
        val results = dates.map { getKorDayOfWeek(it, left, right) }

        // then
        results.forEachIndexed { idx, result ->
            assertThat(result).isEqualTo(expects[idx])
        }
    }
}