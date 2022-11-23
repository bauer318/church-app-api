package ru.wordofgod.api.entity

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.sql.Timestamp
import javax.persistence.*

@Entity
class Media(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id:Long?=null,
    var name: String?=null,
    var path: String?=null,
    @Enumerated(EnumType.STRING)
    var mediaType: MediaType?=null,
    @CreationTimestamp
    var createdAt: Timestamp?=null,
    @UpdateTimestamp
    var updatedAt: Timestamp?=null,
)