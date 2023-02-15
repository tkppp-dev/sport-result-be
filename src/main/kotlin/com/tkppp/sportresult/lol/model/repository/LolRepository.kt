package com.tkppp.sportresult.lol.model.repository

import com.tkppp.sportresult.lol.model.entity.Lol
import org.springframework.data.jpa.repository.JpaRepository

interface LolRepository : JpaRepository<Lol, Long>, LolRepositoryCustom {
}