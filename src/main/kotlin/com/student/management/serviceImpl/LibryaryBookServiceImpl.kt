package com.student.management.serviceImpl

import com.student.management.domain.LibraryBook
import com.student.management.dtos.LibraryBookDto
import com.student.management.repository.LibraryBookRepository
import com.student.management.service.LibyaryBookService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class LibryaryBookServiceImpl
    (
        @Autowired
        private val libraryBookRepository: LibraryBookRepository
    )
    : LibyaryBookService {

    fun checkExistence( id: Long ): LibraryBook {
        var bookFound : Optional<LibraryBook> = libraryBookRepository.findById(id);

        if(! bookFound.isPresent) throw Exception("Book not found with id: ${id}");

        return bookFound.get();
    }

    override fun getBookById(id: Long): LibraryBook {
        return checkExistence(id)
    }

    override fun getAllBooks(): List<LibraryBook> {
        return libraryBookRepository.findAll();
    }

    override fun addBook(book: LibraryBookDto): LibraryBook {
        var bookToSave = LibraryBook(
            book.name,
            book.author,
            book.price,
            book.quantity,
            book.status
        )

        return libraryBookRepository.save(bookToSave);
    }

    override fun updateBook(id: Long, book: LibraryBookDto): LibraryBook {
        var bookToUpdate = checkExistence(id);

        bookToUpdate.name = book.name;
        bookToUpdate.author = book.author;
        bookToUpdate.price = book.price;
        bookToUpdate.quantity = book.quantity;
        bookToUpdate.status = book.status;
        bookToUpdate.id = id

        return libraryBookRepository.save(bookToUpdate);
    }

    override fun deleteBook(id: Long): LibraryBook {
        var bookToDelete = checkExistence(id);

        libraryBookRepository.delete(bookToDelete);

        return bookToDelete;
    }
}