package com.emm.just_chill.feat.post

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany
import jakarta.persistence.Table

@Entity
@Table(name = "course")
data class CourseEntity(

    @Id
    val id: String,

    @Column(nullable = false)
    val name: String,

    @ManyToMany(mappedBy = "courses")
    val students: MutableList<StudentEntity> = mutableListOf(),
)
