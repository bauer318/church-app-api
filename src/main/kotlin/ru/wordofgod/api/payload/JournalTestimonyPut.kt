package ru.wordofgod.api.payload

import ru.wordofgod.api.entity.JournalTestimony

class JournalTestimonyPut (
    val journalTestimonyId:Long?=null,
    var name:String?=null,
    var description:String?=null,
    var content:String?=null,
)
fun JournalTestimonyPut.toJournalTestimonyEntity()= JournalTestimony(
    id=journalTestimonyId,
    name = name,
    description = description,
    content = content,
)
