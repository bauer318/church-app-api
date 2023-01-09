package ru.wordofgod.api.payload

import ru.wordofgod.api.entity.JournalTestimony

class JournalTestimonyRq(
    var name: String?=null,
    var description:String?=null,
    var content:String?=null,
)
fun JournalTestimonyRq.toJournalTestimonyEntity()= JournalTestimony(
    name = name,
    description =  description,
    content = content
)