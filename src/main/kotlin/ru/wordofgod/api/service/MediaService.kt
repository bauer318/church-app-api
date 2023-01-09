package ru.wordofgod.api.service

import org.springframework.stereotype.Service
import ru.wordofgod.api.entity.Media
import ru.wordofgod.api.exception.MediaNotFoundException
import ru.wordofgod.api.payload.*
import ru.wordofgod.api.repository.MediaRepository

@Service
class MediaService(private val mediaRepository:MediaRepository) {

    private fun getOne(mediaId:Long):Media = mediaRepository.findById(mediaId).orElseThrow{
        MediaNotFoundException("Media with id=$mediaId was not found")
    }

    fun getMediaList():List<MediaRs> = mediaRepository.findAll().toListMediaRs()

    fun getMediaById(mediaId:Long):MediaRs=getOne(mediaId).toMediaRs()

    fun createMedia(request:MediaRq):MediaRs=mediaRepository.save(request.toMediaEntity()).toMediaRs()

    fun updatedMedia(mediaId:Long, request:MediaPut):MediaRs{
        var media = getOne(mediaId)
        media.name = request.name
        media.path = request.path
        media.mediaType = request.mediaType
        return mediaRepository.save(media).toMediaRs()
    }

    fun deleteMedia(mediaId:Long):String{
        val media = getOne(mediaId)
        mediaRepository.delete(media)
        return "Media deleted"
    }
}