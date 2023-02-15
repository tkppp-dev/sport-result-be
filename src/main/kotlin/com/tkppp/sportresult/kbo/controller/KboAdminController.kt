package com.tkppp.sportresult.kbo.controller

import com.tkppp.sportresult.kbo.service.KboScheduleService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/admin/kbo")
class KboAdminController(
    private val kboScheduleService: KboScheduleService
) {

    @PutMapping("/schedule")
    fun updateMonthlySchedule(@RequestParam year: Int, @RequestParam month: Int): ResponseEntity<Unit> {
        kboScheduleService.updateSchedule(year, month)
        return ResponseEntity.noContent().build()
    }
}