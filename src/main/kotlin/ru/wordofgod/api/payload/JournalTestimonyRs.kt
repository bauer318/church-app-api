package ru.wordofgod.api.payload

import ru.wordofgod.api.entity.JournalTestimony
import java.sql.Timestamp

class JournalTestimonyRs(
    val journalTestimonyId: Long? = null,
    var name: String? = null,
    var description: String? = null,
    var content: String? = null,
    var createdAt: Timestamp? = null,
    var updatedAt: Timestamp? = null,
)

fun JournalTestimony.toJournalTestimonyRs() = JournalTestimonyRs(
    journalTestimonyId = id,
    name = name,
    description = description,
    content = content,
    createdAt = createdAt,
    updatedAt = updatedAt,
)

fun List<JournalTestimony>.toListJournalTestimonyRs(): List<JournalTestimonyRs> = this.map {
    it.toJournalTestimonyRs()
}
