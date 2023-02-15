package com.tkppp.sportresult.kbo.model.repository

import com.tkppp.sportresult.kbo.model.entity.Kbo
import org.springframework.data.jpa.repository.JpaRepository

interface KboRepository : JpaRepository<Kbo, Long>, KboRepositoryCustom {
}