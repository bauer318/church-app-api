package ru.wordofgod.api.service

import org.springframework.stereotype.Service
import ru.wordofgod.api.entity.Worship
import ru.wordofgod.api.exception.WorshipNotFoundException
import ru.wordofgod.api.payload.*
import ru.wordofgod.api.repository.WorshipRepository

@Service
class WorshipService (private val worshipRepository:WorshipRepository){

    private fun getOne(worshipId:Long):Worship = worshipRepository.findById(worshipId).orElseThrow{
        WorshipNotFoundException("Worship with id $worshipId was not found")
    }

    fun getWorshipList():List<WorshipRs> = worshipRepository.findAll().toListWorshipRs()

    fun getWorshipById(worshipId: Long):WorshipRs = getOne(worshipId).toWorshipRs()

    fun createWorship(request: WorshipRq):WorshipRs=worshipRepository.save(request.toWorshipEntity()).toWorshipRs()

    fun updateWorship(worshipId: Long, request: WorshipPut):WorshipRs{
        var worship = getOne(worshipId)
        worship.name = request.name
        worship.path = request.path
        return worshipRepository.save(worship).toWorshipRs()
    }

    fun deleteWorship(worshipId: Long):String{
        val worship = getOne(worshipId)
        worshipRepository.delete(worship)
        return "Worship deleted"
    }
}