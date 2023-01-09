package ru.wordofgod.api.payload

import ru.wordofgod.api.entity.Worship

class WorshipRq(
    var name: String? = null,
    var path: String? = null,
)

fun WorshipRq.toWorshipEntity() = Worship(
    name = name,
    path = path,
)