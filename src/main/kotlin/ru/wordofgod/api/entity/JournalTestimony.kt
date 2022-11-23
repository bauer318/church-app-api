package ru.wordofgod.api.entity

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.sql.Timestamp
import javax.persistence.*

@Entity
class JournalTestimony(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id:Long?=null,
    var name:String?=null,
    var description:String?=null,
    @Column(columnDefinition = "text")
    var content: String?=null,
    @CreationTimestamp
    var createdAt: Timestamp?=null,
    @UpdateTimestamp
    var updatedAt: Timestamp?=null,
)