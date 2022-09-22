package com.student.management.service

import com.student.management.domain.LibraryBook
import com.student.management.dtos.LibraryBookDto
import org.springframework.stereotype.Service

@Service
interface LibyaryBookRepository  {

    fun getBookById(id: Int): LibraryBook

    fun getAllBooks(): List<LibraryBook>

    fun addBook(book: LibraryBookDto): LibraryBook

    fun updateBook(book: LibraryBookDto): LibraryBook

    fun deleteBook(id: Int): LibraryBook

}