package ru.wordofgod.api.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.wordofgod.api.entity.Worship

interface WorshipRepository : JpaRepository<Worship, Long>