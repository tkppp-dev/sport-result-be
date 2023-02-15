package com.tkppp.sportresult.common.adaptor

import com.tkppp.sportresult.kbo.model.dto.KboMonthlyScheduleDto
import com.tkppp.sportresult.kbo.model.dto.KboRealTimeMatchDataDto
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono
import reactor.core.publisher.Mono

@Component
class KboAdapter(
    private val webClient: WebClient
) {

    fun getMonthlySchedule(year: Int, month: Int): KboMonthlyScheduleDto? {
        return webClient.get()
            .uri {
                it.path("/kbo/schedule")
                    .queryParam("year", year)
                    .queryParam("month", month)
                    .build()
            }
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono<KboMonthlyScheduleDto>()
            .block()
    }

    fun getRealTimeMatchData(): KboRealTimeMatchDataDto? {
        return webClient.get()
            .uri { builder ->
                builder
                    .path("/kbo/realtime")
                    .build()
            }
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(KboRealTimeMatchDataDto::class.java)
            .block()
    }
}