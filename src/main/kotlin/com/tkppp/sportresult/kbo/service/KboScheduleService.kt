package com.tkppp.sportresult.kbo.service

import com.tkppp.sportresult.common.helper.getMonthStartAndEndDatetime
import com.tkppp.sportresult.common.adaptor.KboAdapter
import com.tkppp.sportresult.kbo.model.repository.KboRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class KboScheduleService(
    private val kboRepository: KboRepository,
    private val kboAdapter: KboAdapter
) {

    @Transactional
    fun updateSchedule(year: Int, month: Int) {
        val (from, to) = getMonthStartAndEndDatetime(year, month)

        kboRepository.findMatchesBetweenPeriod(from, to).let {
            kboRepository.deleteAll(it)
        }

        kboAdapter.getMonthlySchedule(year, month)?.let {
            kboRepository.saveAll(it.toEntities())
        }
    }

}