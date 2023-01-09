package ru.wordofgod.api.payload

import ru.wordofgod.api.entity.Media
import ru.wordofgod.api.entity.MediaType

class MediaRq(
    var name: String? = null,
    var path: String? = null,
    var mediaType: MediaType? = null,
)

fun MediaRq.toMediaEntity()= Media(
    name = name,
    path = path,
    mediaType = mediaType,
)