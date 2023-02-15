package com.tkppp.sportresult.kbo.model.entity

import com.tkppp.sportresult.common.model.entity.MatchBaseEntity
import com.tkppp.sportresult.kbo.model.dto.KboRealTimeMatchDataDto
import com.tkppp.sportresult.kbo.model.type.KboMatchState
import com.tkppp.sportresult.kbo.model.type.KboTeam
import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Kbo(
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null,
  @Enumerated(EnumType.STRING) var matchState: KboMatchState,
  @Enumerated(EnumType.STRING) val home: KboTeam,
  @Enumerated(EnumType.STRING) val away: KboTeam,
  matchDatetime: LocalDateTime,
  homeScore: Int,
  awayScore: Int
) : MatchBaseEntity(matchDatetime, homeScore, awayScore) {

  fun update(matchData: KboRealTimeMatchDataDto.MatchData) {
    if(matchData.home != home && matchData.away != away) {
      TODO("매치 불일치 예외 만들어서 던져야함")
    }
    super.update(matchData.homeScore, matchData.awayScore)
    this.matchState = matchData.matchState
  }
}