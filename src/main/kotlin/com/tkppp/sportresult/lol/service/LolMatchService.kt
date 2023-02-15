package com.tkppp.sportresult.lol.service

import com.tkppp.sportresult.common.helper.ON_TIME
import com.tkppp.sportresult.common.helper.getWeekStartAndEndDatetime
import com.tkppp.sportresult.lol.model.dto.response.LolDayMatchResponse
import com.tkppp.sportresult.lol.model.dto.response.LolWeekMatchResponse
import com.tkppp.sportresult.lol.model.repository.LolRepository
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.LocalDateTime

@Service
class LolMatchService(
    private val lolRepository: LolRepository,
) {

    fun getDayMatches(date: LocalDate): LolDayMatchResponse {
        val (from, to) = date to date.plusDays(1)
        return lolRepository
            .findMatchesBetweenPeriod(LocalDateTime.of(from, ON_TIME), LocalDateTime.of(to, ON_TIME))
            .let { LolDayMatchResponse.from(it) }
    }

    fun getWeekMatches(): LolWeekMatchResponse {
        val (from, to) = getWeekStartAndEndDatetime()
        return lolRepository
            .findMatchesBetweenPeriod(from, to)
            .let { LolWeekMatchResponse.from(it) }
    }
}