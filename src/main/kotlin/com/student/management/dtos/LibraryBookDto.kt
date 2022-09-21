package com.student.management.dtos

data class LibraryBookDto(
    var name: String? = null,
    var author: String? = null,
    var price: Double? = null,
    var quantity: Int? = null,
    var status: String? = null
)
