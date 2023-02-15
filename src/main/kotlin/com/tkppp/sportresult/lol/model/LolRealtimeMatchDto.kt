package com.tkppp.sportresult.lol.model

import com.tkppp.sportresult.lol.model.type.LolMatchState
import com.tkppp.sportresult.lol.model.type.LolTeam

data class LolRealtimeMatchDto(
    val matches: List<Match>
) {
    data class Match(
        val startTime: List<Int>,
        val state: LolMatchState,
        val home: LolTeam,
        val away: LolTeam,
        val homeScore: Int,
        val awayScore: Int
    )
}