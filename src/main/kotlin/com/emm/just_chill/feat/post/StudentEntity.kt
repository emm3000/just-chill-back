package com.emm.just_chill.feat.post

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.Table

@Entity
@Table(name = "students")
data class StudentEntity(

    @Id
    val id: String,

    @Column(nullable = false)
    val name: String,

    @ManyToMany(cascade = [(CascadeType.ALL)])
    @JoinTable(
        name = "student_course",
        joinColumns = [JoinColumn(name = "students_id")],
        inverseJoinColumns = [JoinColumn(name = "course_id")]
    )
    val courses: MutableList<CourseEntity> = mutableListOf(),
)
