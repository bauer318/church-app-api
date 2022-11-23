package ru.wordofgod.api.payload

import ru.wordofgod.api.entity.Streaming


class StreamingRq(
    var videoId: String? = null,
)

fun StreamingRq.toStreamingEntity()= Streaming(videoId = videoId)