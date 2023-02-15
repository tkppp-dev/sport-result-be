package com.tkppp.sportresult.lol.model.entity

import com.tkppp.sportresult.common.model.entity.MatchBaseEntity
import com.tkppp.sportresult.kbo.model.dto.KboRealTimeMatchDataDto
import com.tkppp.sportresult.kbo.model.type.KboMatchState
import com.tkppp.sportresult.lol.model.type.LolMatchState
import com.tkppp.sportresult.lol.model.type.LolTeam
import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Lol(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null,
    @Column(nullable = false) var matchState: LolMatchState,
    @Column(nullable = false) val home: LolTeam,
    @Column(nullable = false) val away: LolTeam,
    matchDatetime: LocalDateTime,
    homeScore: Int,
    awayScore: Int,
) : MatchBaseEntity(matchDatetime, homeScore, awayScore) {

}