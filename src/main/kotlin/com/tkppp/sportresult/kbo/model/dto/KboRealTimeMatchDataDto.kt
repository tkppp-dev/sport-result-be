package com.tkppp.sportresult.kbo.model.dto

import com.tkppp.sportresult.kbo.model.type.KboMatchState
import com.tkppp.sportresult.kbo.model.type.KboTeam

data class KboRealTimeMatchDataDto(
    val matches: List<MatchData>
) {
    data class MatchData(
        val matchState: KboMatchState,
        val home: KboTeam,
        val away: KboTeam,
        val homeScore: Int,
        val awayScore: Int,
    )
}