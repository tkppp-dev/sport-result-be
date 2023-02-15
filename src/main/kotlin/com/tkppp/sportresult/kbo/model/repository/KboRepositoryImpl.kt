package com.tkppp.sportresult.kbo.model.repository

import com.tkppp.sportresult.common.model.repository.QuerydslBaseRepository
import com.tkppp.sportresult.kbo.model.entity.Kbo
import com.tkppp.sportresult.kbo.model.entity.QKbo
import java.time.LocalDateTime

class KboRepositoryImpl : KboRepositoryCustom, QuerydslBaseRepository(Kbo::class.java) {
    val qKbo = QKbo.kbo

    override fun findMatchesBetweenPeriod(from: LocalDateTime, to: LocalDateTime): List<Kbo> {
        return from(qKbo)
            .where(qKbo.matchDatetime.between(from, to))
            .fetch()
    }
}