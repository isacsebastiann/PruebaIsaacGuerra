package com.example.momentouno.repository

import com.example.momentouno.model.Assistant
import com.example.momentouno.model.Conference
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface ConferenceRepository:JpaRepository<Conference,Long> {
    fun findById (id: Long?): Conference?
}
@Repository
interface AssistantRepository : JpaRepository<Assistant, Long> {
    fun findById (id: Long?): Conference?
}

