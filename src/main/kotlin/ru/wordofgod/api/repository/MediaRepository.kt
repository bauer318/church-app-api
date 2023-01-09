package ru.wordofgod.api.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.wordofgod.api.entity.Media

interface MediaRepository :JpaRepository<Media,Long>