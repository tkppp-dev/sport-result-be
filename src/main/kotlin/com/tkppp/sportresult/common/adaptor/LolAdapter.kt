package com.tkppp.sportresult.common.adaptor

import com.tkppp.sportresult.lol.model.dto.LolMonthlyScheduleDto
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono

@Component
class LolAdapter(
    private val webClient: WebClient
) {

    fun getMonthlySchedule(year: Int, month: Int): LolMonthlyScheduleDto? {
        return webClient.get()
            .uri { builder ->
                builder.path("/lol/schedule")
                    .queryParam("year", year)
                    .queryParam("month", month)
                    .build()
            }
            .retrieve()
            .bodyToMono<LolMonthlyScheduleDto>()
            .block()
    }
}