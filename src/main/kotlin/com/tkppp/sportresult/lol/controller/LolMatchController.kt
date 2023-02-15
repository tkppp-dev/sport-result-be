package com.tkppp.sportresult.lol.controller

import com.tkppp.sportresult.lol.model.dto.response.LolDayMatchResponse
import com.tkppp.sportresult.lol.model.dto.response.LolWeekMatchResponse
import com.tkppp.sportresult.lol.service.LolMatchService
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@RestController
@RequestMapping("/api/lol")
class LolMatchController(
    private val lolMatchService: LolMatchService
) {

    @GetMapping("day")
    fun getDayMatches(@RequestParam @DateTimeFormat(style = "yyyy-MM-dd") date: LocalDate): LolDayMatchResponse {
        return lolMatchService.getDayMatches(date)
    }

    @GetMapping("week")
    fun getWeekMatches(): LolWeekMatchResponse {
        return lolMatchService.getWeekMatches()
    }
}