package ru.wordofgod.api.payload

import ru.wordofgod.api.entity.Media
import ru.wordofgod.api.entity.MediaType
import java.sql.Timestamp


class MediaRs(
    val mediaId: Long? = null,
    var name: String? = null,
    var path: String? = null,
    var mediaType: MediaType? = null,
    var createdAt: Timestamp? = null,
    var updatedAt: Timestamp? = null,
)

fun Media.toMediaRs()=MediaRs(
    mediaId = id,
    name = name,
    path=path,
    mediaType = mediaType,
    createdAt = createdAt,
    updatedAt = updatedAt,
)

fun List<Media>.toListMediaRs():List<MediaRs> = this.map{
    it.toMediaRs()
}