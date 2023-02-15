package com.tkppp.sportresult.lol.model.dto.response

import com.tkppp.sportresult.common.helper.toTimeString
import com.tkppp.sportresult.lol.model.entity.Lol
import com.tkppp.sportresult.lol.model.type.LolTeam

data class LolDayMatchResponse(
    val matches: List<Match>
) {
    companion object {
        fun from(entities: List<Lol>): LolDayMatchResponse {
            return LolDayMatchResponse(
                matches = entities.map {
                    Match(
                        startTime = it.matchDatetime.toTimeString(),
                        state = it.matchState.value,
                        home = it.home,
                        away = it.away,
                        homeScore = it.homeScore,
                        awayScore = it.awayScore
                    )
                }
            )
        }
    }

    data class Match(
        val startTime: String,
        val state: String,
        val home: LolTeam,
        val away: LolTeam,
        val homeScore: Int,
        val awayScore: Int,
    )
}