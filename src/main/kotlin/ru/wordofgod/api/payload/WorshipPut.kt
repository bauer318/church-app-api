package ru.wordofgod.api.payload

import ru.wordofgod.api.entity.Worship

class WorshipPut(
    val worshipId: Long? = null,
    var name: String? = null,
    var path: String? = null,
)

fun WorshipPut.toWorshipEntity() = Worship(
    id = worshipId,
    name = name,
    path = path,
)