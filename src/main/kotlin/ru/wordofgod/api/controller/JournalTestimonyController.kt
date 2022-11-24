package ru.wordofgod.api.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.wordofgod.api.payload.JournalTestimonyPut
import ru.wordofgod.api.payload.JournalTestimonyRq
import ru.wordofgod.api.payload.JournalTestimonyRs
import ru.wordofgod.api.service.JournalTestimonyService

@RestController
@RequestMapping("/journal")
class JournalTestimonyController(private val journalTestimonyService: JournalTestimonyService) {
    @GetMapping
    fun getJournalTestimonyList(): List<JournalTestimonyRs> = journalTestimonyService.getJournalTestimonyList()

    @GetMapping("/{journalTestimonyId}")
    fun getJournalTestimonyById(@PathVariable journalTestimonyId: Long): JournalTestimonyRs =
        journalTestimonyService.getJournalTestimonyById(journalTestimonyId)

    @PostMapping
    fun saveJournalTestimony(@RequestBody request: JournalTestimonyRq): JournalTestimonyRs =
        journalTestimonyService.createJournalTestimony(request)

    @PutMapping("/{journalTestimonyId}")
    fun updateJournalTestimony(@PathVariable journalTestimonyId:Long,@RequestBody request:JournalTestimonyPut):JournalTestimonyRs =
        journalTestimonyService.updatedJournalTestimony(journalTestimonyId,request)

    @DeleteMapping("/{journalTestimonyId}")
    fun deleteJournalTestimony(@PathVariable journalTestimonyId:Long):ResponseEntity<String> =
        ResponseEntity.ok(journalTestimonyService.deleteJournalTestimony(journalTestimonyId))
}