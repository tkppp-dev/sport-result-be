package com.tkppp.sportresult.kbo.service

import com.tkppp.sportresult.common.helper.ON_TIME
import com.tkppp.sportresult.kbo.model.dto.response.KboDayMatchResponse
import com.tkppp.sportresult.kbo.model.repository.KboRepository
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.LocalDateTime

@Service
class KboMatchService(
    private val kboRepository: KboRepository
) {

    fun getDayMatches(date: LocalDate): KboDayMatchResponse {
        val (from, to) = date to date.plusDays(1)
        return kboRepository
            .findMatchesBetweenPeriod(LocalDateTime.of(from, ON_TIME), LocalDateTime.of(to, ON_TIME))
            .let { KboDayMatchResponse.from(it) }
    }

}