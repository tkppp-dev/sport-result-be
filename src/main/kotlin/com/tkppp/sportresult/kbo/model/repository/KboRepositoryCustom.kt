package com.tkppp.sportresult.kbo.model.repository

import com.tkppp.sportresult.kbo.model.entity.Kbo
import java.time.LocalDateTime

interface KboRepositoryCustom {
    fun findMatchesBetweenPeriod(from: LocalDateTime, to: LocalDateTime): List<Kbo>
}