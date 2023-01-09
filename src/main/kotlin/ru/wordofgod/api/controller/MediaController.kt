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
import ru.wordofgod.api.payload.MediaPut
import ru.wordofgod.api.payload.MediaRq
import ru.wordofgod.api.payload.MediaRs
import ru.wordofgod.api.service.MediaService

@RestController
@RequestMapping("/media")
class MediaController(private val mediaService:MediaService) {

    @GetMapping
    fun getMediaList():List<MediaRs> = mediaService.getMediaList()

    @GetMapping("/{mediaId}")
    fun getMediaById(@PathVariable mediaId:Long):MediaRs=
        mediaService.getMediaById(mediaId)

    @PostMapping
    fun saveMedia(@RequestBody request: MediaRq):MediaRs =
        mediaService.createMedia(request)

    @PutMapping("/{mediaId}")
    fun updateMedia(@PathVariable mediaId: Long, @RequestBody request: MediaPut):MediaRs =
        mediaService.updatedMedia(mediaId, request)

    @DeleteMapping("/{mediaId}")
    fun deleteMedia(@PathVariable mediaId:Long):ResponseEntity<String> =
        ResponseEntity.ok(mediaService.deleteMedia(mediaId))
}