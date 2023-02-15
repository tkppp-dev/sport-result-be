package com.tkppp.sportresult.lol.model.dto

import com.tkppp.sportresult.lol.model.entity.Lol
import com.tkppp.sportresult.lol.model.type.LolMatchState
import com.tkppp.sportresult.lol.model.type.LolTeam
import java.time.LocalDateTime

data class LolMonthlyScheduleDto(
    val dayMatches: List<DayMatches>
) {
    data class DayMatches(
        val matches: List<Match>
    ) {
        data class Match(
            val matchDatetime: LocalDateTime,
            val state: LolMatchState,
            val home: LolTeam,
            val away: LolTeam,
            val homeScore: Int,
            val awayScore: Int
        )
    }

    fun toEntities(): List<Lol> {
        return dayMatches.map { dayMatches ->
            dayMatches.matches.map { match ->
                Lol(
                    matchDatetime = match.matchDatetime,
                    matchState = match.state,
                    home = match.home,
                    away = match.away,
                    homeScore = match.homeScore,
                    awayScore = match.awayScore
                )
            }
        }.flatten()
    }
}