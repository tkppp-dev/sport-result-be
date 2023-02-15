package com.tkppp.sportresult.kbo.model.dto

import com.tkppp.sportresult.kbo.model.entity.Kbo
import com.tkppp.sportresult.kbo.model.type.KboMatchState
import com.tkppp.sportresult.kbo.model.type.KboTeam
import java.time.LocalDateTime

data class KboMonthlyScheduleDto(
    val dayMatches: List<DayMatches>
) {
    data class DayMatches(
        val matchDate: List<Int>,
        val matches: List<MatchData>
    ) {
        data class MatchData(
            val startTime: List<Int>,
            val matchState: KboMatchState,
            val home: KboTeam,
            val away: KboTeam,
            val homeScore: Int,
            val awayScore: Int,
        )
    }

    fun toEntities(): List<Kbo> =
        dayMatches.map { dayMatches ->
            val (year, month, day) = dayMatches.matchDate
            dayMatches.matches.map { matchData ->
                val (hour, min) = matchData.startTime
                Kbo(
                    matchDatetime = LocalDateTime.of(year, month, day, hour, min),
                    matchState = matchData.matchState,
                    home = matchData.home,
                    away = matchData.away,
                    homeScore = matchData.homeScore,
                    awayScore = matchData.awayScore
                )
            }
        }.flatten()
}