package ru.wordofgod.api.service

import ru.wordofgod.api.entity.Streaming
import ru.wordofgod.api.exception.StreamingNotFoundException
import ru.wordofgod.api.payload.*
import ru.wordofgod.api.repository.StreamingRepository
import org.springframework.stereotype.Service

@Service
class StreamingService(private val streamRepository: StreamingRepository) {

    fun getStreamingList(): List<StreamingRs> =
        streamRepository.findAll().toListStreamingRs()

    fun getStreaming(streamingId: Long): StreamingRs =
        getOne(streamingId).toStreamingRs()


    fun createStreaming(request: StreamingRq): StreamingRs =
        streamRepository.save(request.toStreamingEntity()).toStreamingRs()


    fun updateStreaming(streamingId: Long, request: StreamingPut): StreamingRs {
        val streaming = getOne(streamingId)
        streaming.videoId = request.videoId
        return streamRepository.save(streaming).toStreamingRs()
    }


    fun deleteStreaming(streamingId: Long): String {
        val streaming = getOne(streamingId)
        streamRepository.delete(streaming)
        return "Streaming deleted!"
    }

    private fun getOne(streamingId: Long): Streaming =
        streamRepository.findById(streamingId)
            .orElseThrow { StreamingNotFoundException("Streaming with id=$streamingId was not found") }
}
