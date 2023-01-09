package ru.wordofgod.api.payload

import ru.wordofgod.api.entity.Worship
import java.sql.Timestamp

class WorshipRs(
    val worshipId: Long? = null,
    var name: String? = null,
    var path: String? = null,
    var createdAt: Timestamp? = null,
    var updatedAt: Timestamp? = null,

    )

fun Worship.toWorshipRs() = WorshipRs(
    worshipId = id,
    name = name,
    path = path,
    createdAt = createdAt,
    updatedAt = updatedAt,
)

fun List<Worship>.toListWorshipRs(): List<WorshipRs> = this.map {
    it.toWorshipRs()
}