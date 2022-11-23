package ru.wordofgod.api.payload

import ru.wordofgod.api.entity.Streaming
import java.sql.Timestamp

class StreamingPut(
    val streamingId: Long? = null,
    var videoId: String? = null,
)

fun StreamingPut.toStreamingEntity() = Streaming(
    id = streamingId,
    videoId = videoId,
)