package com.student.management.repository

import com.student.management.domain.LibraryBook
import org.springframework.data.jpa.repository.JpaRepository

interface LibraryBookRepository : JpaRepository<LibraryBook, Long> {
}