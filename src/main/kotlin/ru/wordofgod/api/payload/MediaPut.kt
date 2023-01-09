package ru.wordofgod.api.payload

import ru.wordofgod.api.entity.Media
import ru.wordofgod.api.entity.MediaType

class MediaPut(
    val mediaId: Long? = null,
    var name: String? = null,
    var path: String? = null,
    var mediaType: MediaType? = null,
)

fun MediaPut.toMediaEntity() = Media(
    id=mediaId,
    name = name,
    path=path,
    mediaType=mediaType
)