package com.student.management.domain

import javax.persistence.*

@Entity
@Table(name = "library_books")
data class LibraryBook(
        var name: String? = null,
        var author: String? = null,
        var price: Double? = null,
        var quantity: Int? = null,
        var status: String? = null
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    open var id: Long? = null

}