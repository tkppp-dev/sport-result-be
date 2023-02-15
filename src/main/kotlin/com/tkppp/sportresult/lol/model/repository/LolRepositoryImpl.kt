package com.tkppp.sportresult.lol.model.repository

import com.tkppp.sportresult.common.helper.getWeekStartAndEndDatetime
import com.tkppp.sportresult.common.model.repository.QuerydslBaseRepository
import com.tkppp.sportresult.lol.model.entity.Lol
import com.tkppp.sportresult.lol.model.entity.QLol
import java.time.LocalDateTime

class LolRepositoryImpl : LolRepositoryCustom, QuerydslBaseRepository(Lol::class.java) {
    val qLol = QLol.lol

    override fun findMatchesBetweenPeriod(from: LocalDateTime, to: LocalDateTime): List<Lol> {
       return from(qLol)
           .where(qLol.matchDatetime.between(from, to))
           .fetch()
    }

    override fun findWeekMatches(): List<Lol> {
        val (from, to) = getWeekStartAndEndDatetime()
        return findMatchesBetweenPeriod(from, to)
    }
}