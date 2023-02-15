package com.tkppp.sportresult.common.model.entity

import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class MatchBaseEntity(
    val matchDatetime: LocalDateTime,
    @Column(nullable = false) var homeScore: Int,
    @Column(nullable = false) var awayScore: Int,
) {

    fun update(homeScore: Int, awayScore: Int) {
        this.homeScore = homeScore
        this.awayScore = awayScore
    }
}