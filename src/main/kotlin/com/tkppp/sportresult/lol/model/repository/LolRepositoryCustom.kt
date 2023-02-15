package com.tkppp.sportresult.lol.model.repository

import com.tkppp.sportresult.lol.model.entity.Lol
import java.time.LocalDateTime

interface LolRepositoryCustom {
    fun findMatchesBetweenPeriod(from: LocalDateTime, to: LocalDateTime): List<Lol>
    fun findWeekMatches(): List<Lol>
}