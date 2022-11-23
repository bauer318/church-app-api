package ru.wordofgod.api.controller

import ru.wordofgod.api.payload.StreamingPut
import ru.wordofgod.api.payload.StreamingRq
import ru.wordofgod.api.payload.StreamingRs
import ru.wordofgod.api.service.StreamingService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/streaming")
class StreamingController(private val streamingService: StreamingService) {

    @GetMapping
    fun getStreamingList(): List<StreamingRs> = streamingService.getStreamingList()


    @GetMapping("/{streamingId}")
    fun getStreaming(@PathVariable streamingId: Long): StreamingRs = streamingService.getStreaming(streamingId)

    @PostMapping
    fun saveStreaming(@RequestBody req: StreamingRq): StreamingRs = streamingService.createStreaming(req)

    @PutMapping("/{streamingId}")
    fun updateStreaming(@PathVariable streamingId: Long, @RequestBody req: StreamingPut): StreamingRs =
        streamingService.updateStreaming(streamingId, req)

    @DeleteMapping("/{streamingId}")
    fun deleteStreaming(@PathVariable streamingId: Long): ResponseEntity<String> =
        ResponseEntity.ok(streamingService.deleteStreaming(streamingId))
}