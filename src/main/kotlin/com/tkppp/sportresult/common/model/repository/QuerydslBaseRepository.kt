package com.tkppp.sportresult.common.model.repository

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

class QuerydslBaseRepository(domainClass: Class<*>) : QuerydslRepositorySupport(domainClass) {
    @PersistenceContext
    override fun setEntityManager(em: EntityManager) {
        super.setEntityManager(em)
    }
}