package com.student.management.service

import com.student.management.domain.LibraryBook
import com.student.management.dtos.LibraryBookDto
import org.springframework.stereotype.Service

@Service
interface LibyaryBookService  {

    fun getBookById(id: Long): LibraryBook

    fun getAllBooks(): List<LibraryBook>

    fun addBook(book: LibraryBookDto): LibraryBook

    fun updateBook(id: Long, book: LibraryBookDto): LibraryBook

    fun deleteBook(id: Long): LibraryBook

}