package ru.wordofgod.api.repository

import ru.wordofgod.api.entity.Streaming
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StreamingRepository:JpaRepository<Streaming, Long>