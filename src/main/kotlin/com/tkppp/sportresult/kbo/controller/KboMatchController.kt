package com.tkppp.sportresult.kbo.controller

import com.tkppp.sportresult.kbo.model.dto.response.KboDayMatchResponse
import com.tkppp.sportresult.kbo.service.KboMatchService
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@RestController
@RequestMapping("/api/kbo")
class KboMatchController(
    private val kboMatchService: KboMatchService
) {

    @GetMapping
    fun get(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") date: LocalDate): KboDayMatchResponse
        = kboMatchService.getDayMatches(date)

}