package com.library.books.controller;

import com.library.books.model.Book;
import com.library.books.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
@CrossOrigin(origins = "http://localhost:4200")
public class BookController {

    private final BookService bookService;

    // GET /books - All Books
    // GET /books/{bookId} - Get book By ID
    // GET /books/search?name="searchText" - Based on search text
    // POST /books - RequestBody - Create Book
    // PUT /books/{bookId} - RequestBody - Update Book
    // DELETE /books/{bookId} - Delete book by ID

    @GetMapping
    public List<Book> retrieveAllBooks() {
        return bookService.retrieveAllBooks();
    }

    @GetMapping(path = "/{bookId}")
    public Book retrieveBookById(@PathVariable Long bookId) {
        return bookService.retrieveBookById(bookId);
    }

    @GetMapping("/search")
    public List<Book> bookOrAuthorNameContain(@RequestParam(value = "name", required = false) String name) {
        return bookService.bookOrAuthorNameContain(name);
    }

    // Create: Book

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Book addBook(@RequestBody Book bookRO) {
        return bookService.addBook(bookRO);
    }

    // Update: Book

    @PutMapping(path = "/{bookId}")
    public Book updateBookById(@PathVariable Long bookId, @RequestBody Book bookRO) {
        return bookService.updateBook(bookId, bookRO);
    }

    // Delete: Book

    @DeleteMapping(path = "/{bookId}")
    public void deleteBookById(@PathVariable Long bookId) {
        bookService.deleteBookById(bookId);
    }
}