package com.student.management.controller

import com.student.management.domain.LibraryBook
import com.student.management.dtos.LibraryBookDto
import com.student.management.serviceImpl.LibryaryBookServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin
@RequestMapping("/api/v1/library-books")
class LibraryBookController(
    @Autowired
    private var libraryBookService: LibryaryBookServiceImpl
) {

    @GetMapping("/all")
    fun getAllLibraryBooks() = libraryBookService.getAllBooks()

    @GetMapping("/available/{id}")
    fun getAvailableBooksByLibraryId(id: Long) = libraryBookService.getBookById(id)

    @PostMapping("/add")
    fun addBookToLibrary(@RequestBody book: LibraryBookDto): ResponseEntity<LibraryBook> {

        var bookSaved : LibraryBook = libraryBookService.addBook(book)

        return ResponseEntity.ok(bookSaved)
    }

    @PutMapping("/update/{id}")
    fun updateBook(@PathVariable id: Long, @RequestBody book: LibraryBookDto): ResponseEntity<LibraryBook> {

        var bookUpdated : LibraryBook = libraryBookService.updateBook(id, book)

        return ResponseEntity.ok(bookUpdated)
    }

    @DeleteMapping("/delete/{id}")
    fun deleteBook(@PathVariable id: Long) = libraryBookService.deleteBook(id)

}