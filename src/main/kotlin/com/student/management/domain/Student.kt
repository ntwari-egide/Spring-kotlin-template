package com.student.management.domain

import javax.persistence.*

@Entity
@Table(name = "student")
data class Student( val name: String="", val age: Int, val address: String) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    open var id: Long? = null
}
