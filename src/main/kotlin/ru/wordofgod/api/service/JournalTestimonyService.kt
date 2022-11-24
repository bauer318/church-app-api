package ru.wordofgod.api.service

import org.springframework.stereotype.Service
import ru.wordofgod.api.entity.JournalTestimony
import ru.wordofgod.api.exception.JournalTestimonyNotFoundException
import ru.wordofgod.api.payload.*
import ru.wordofgod.api.repository.JournalTestimonyRepository

@Service
class JournalTestimonyService(private val journalTestimonyRepository: JournalTestimonyRepository) {

    private fun getOne(journalTestimonyId: Long): JournalTestimony =
        journalTestimonyRepository.findById(journalTestimonyId).orElseThrow {
            JournalTestimonyNotFoundException("Journal or Testimony with id=$journalTestimonyId was not found")
        }

    fun getJournalTestimonyList(): List<JournalTestimonyRs> =
        journalTestimonyRepository.findAll().toListJournalTestimonyRs()

    fun getJournalTestimonyById(journalTestimonyId:Long):JournalTestimonyRs=
        getOne(journalTestimonyId).toJournalTestimonyRs()

    fun createJournalTestimony(request:JournalTestimonyRq):JournalTestimonyRs =
        journalTestimonyRepository.save(request.toJournalTestimonyEntity()).toJournalTestimonyRs()

    fun updatedJournalTestimony(journalTestimonyId:Long, request: JournalTestimonyPut):JournalTestimonyRs{
        val journalTestimony = getOne(journalTestimonyId)
        journalTestimony.name = request.name
        journalTestimony.description = request.description
        journalTestimony.content = request.content
        return journalTestimonyRepository.save(journalTestimony).toJournalTestimonyRs()
    }

    fun deleteJournalTestimony(journalTestimonyId:Long):String{
        val journalTestimony = getOne(journalTestimonyId)
        journalTestimonyRepository.delete(journalTestimony)
        return "Journal or Testimony deleted"
    }
}