package com.tkppp.sportresult.lol.model.dto.response

import com.tkppp.sportresult.common.helper.toKorDateString
import com.tkppp.sportresult.common.helper.toTimeString
import com.tkppp.sportresult.lol.model.entity.Lol

data class LolWeekMatchResponse(
    val dayMatches: List<DayMatch>
) {
    companion object {
        fun from(entities: List<Lol>): LolWeekMatchResponse {
            return entities
                .sortedBy { it.matchDatetime }
                .groupBy { it.matchDatetime }
                .map { (key, value) -> DayMatch(key.toKorDateString("-", "(", ")"), DayMatch.from(value)) }
                .let { LolWeekMatchResponse(it) }
        }
    }

    data class DayMatch(
        val date: String,
        val matches: List<Match>
    ) {
        companion object {
            fun from(entities: List<Lol>): List<Match> = entities.map { entity ->
                Match(
                    startTime = entity.matchDatetime.toTimeString(),
                    state = entity.matchState.value,
                    home = entity.home.shortName,
                    away = entity.away.shortName,
                    homeScore = entity.homeScore,
                    awayScore = entity.awayScore
                )
            }
        }

        data class Match(
            val startTime: String,
            val state: String,
            val home: String,
            val away: String,
            val homeScore: Int,
            val awayScore: Int,
        )
    }

}