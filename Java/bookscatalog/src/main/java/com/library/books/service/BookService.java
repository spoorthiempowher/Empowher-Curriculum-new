package com.library.books.service;

import com.library.books.model.Book;
import com.library.books.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> retrieveAllBooks() {
        return (List<Book>)bookRepository.findAll();
    }

    public Book retrieveBookById(Long bookId) {
        return bookRepository.findById(bookId).get();
    }

    public List<Book> bookOrAuthorNameContain(String bookOrAuthorName) {
        return bookRepository.searchByBookNameOrAuthorName(bookOrAuthorName);
    }

    // Create: Book

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    // Update: Book

    public Book updateBook(Long bookId, Book book) {
        if (bookRepository.existsById(bookId)) {
            return bookRepository.save(book);
        } else {
            System.out.println("Error case");
            return null;
        }
    }

    // Delete: Book

    public void deleteBookById(Long bookId) {
        bookRepository.deleteById(bookId);
    }
}