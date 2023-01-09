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
import ru.wordofgod.api.payload.WorshipPut
import ru.wordofgod.api.payload.WorshipRq
import ru.wordofgod.api.payload.WorshipRs
import ru.wordofgod.api.service.WorshipService

@RestController
@RequestMapping("/worship")
class WorshipController(private val worshipService:WorshipService) {

    @GetMapping
    fun getWorshipList():List<WorshipRs> = worshipService.getWorshipList()

    @GetMapping("/{worshipId}")
    fun getWorshipById(@PathVariable worshipId:Long):WorshipRs =
        worshipService.getWorshipById(worshipId)

    @PostMapping
    fun saveWorship(@RequestBody request:WorshipRq):WorshipRs = worshipService.createWorship(request)

    @PutMapping("/{worshipId}")
    fun updateWorship(@PathVariable worshipId: Long, @RequestBody request: WorshipPut):WorshipRs =
        worshipService.updateWorship(worshipId,request)

    @DeleteMapping("/{worshipId}")
    fun deleteWorship(@PathVariable worshipId: Long):ResponseEntity<String> =
        ResponseEntity.ok(worshipService.deleteWorship(worshipId))
}