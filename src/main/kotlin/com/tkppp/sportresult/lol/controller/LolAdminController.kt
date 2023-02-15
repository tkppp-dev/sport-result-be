package com.tkppp.sportresult.lol.controller

import com.tkppp.sportresult.lol.service.LolScheduleService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/admin/lol")
class LolAdminController(
    private val lolScheduleService: LolScheduleService
) {

    @PutMapping("/schedule")
    fun update(@RequestParam year: Int, @RequestParam month: Int): ResponseEntity<Unit> {
        lolScheduleService.updateSchedule(year, month)
        return ResponseEntity.noContent().build()
    }
}