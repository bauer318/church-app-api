package ru.wordofgod.api.payload

import ru.wordofgod.api.entity.Streaming
import java.sql.Timestamp

class StreamingRs(
    val streamingId: Long? = null,
    var videoId: String? = null,
    var createdAt: Timestamp? = null,
    var updatedAt: Timestamp? = null,
)

fun Streaming.toStreamingRs() = StreamingRs(
    streamingId = id,
    videoId = videoId,
    createdAt = createdAt,
    updatedAt = updatedAt,
)

fun List<Streaming>.toListStreamingRs(): List<StreamingRs> = this.map {
    it.toStreamingRs()
}