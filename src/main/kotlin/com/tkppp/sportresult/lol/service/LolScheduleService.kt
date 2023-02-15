package com.tkppp.sportresult.lol.service

import com.tkppp.sportresult.common.adaptor.LolAdapter
import com.tkppp.sportresult.common.helper.getMonthStartAndEndDatetime
import com.tkppp.sportresult.lol.model.repository.LolRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class LolScheduleService(
    private val lolRepository: LolRepository,
    private val lolAdapter: LolAdapter
) {

    @Transactional
    fun updateSchedule(year: Int, month: Int) {
        val (from, to) = getMonthStartAndEndDatetime(year, month)

        lolRepository.findMatchesBetweenPeriod(from, to).let{
            lolRepository.deleteAll(it)
        }

        lolAdapter.getMonthlySchedule(year, month)?.let {
            lolRepository.saveAll(it.toEntities())
        }
    }
}