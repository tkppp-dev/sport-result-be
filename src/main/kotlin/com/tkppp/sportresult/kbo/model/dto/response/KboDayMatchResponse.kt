package com.tkppp.sportresult.kbo.model.dto.response

import com.tkppp.sportresult.common.helper.toDateString
import com.tkppp.sportresult.common.helper.toTimeString
import com.tkppp.sportresult.kbo.model.entity.Kbo

data class KboDayMatchResponse(
    val matches: List<MatchInfo>
) {

    companion object {
        fun from(matches: List<Kbo>): KboDayMatchResponse {
            return KboDayMatchResponse(
                matches = matches.map {
                    MatchInfo(
                        matchState = it.matchState.state,
                        matchDate = it.matchDatetime.toDateString(""),
                        startTime = it.matchDatetime.toTimeString(),
                        home = it.home.fullName,
                        away = it.away.fullName,
                        homeCode = it.home.code,
                        awayCode = it.away.code,
                        homeScore = it.homeScore,
                        awayScore = it.awayScore
                    )
                }
            )
        }
    }

    data class MatchInfo(
        val matchState: String,
        val matchDate: String,
        val startTime: String,
        val home: String,
        val away: String,
        val homeCode: String,
        val awayCode: String,
        val homeScore: Int,
        val awayScore: Int,
    )
}
