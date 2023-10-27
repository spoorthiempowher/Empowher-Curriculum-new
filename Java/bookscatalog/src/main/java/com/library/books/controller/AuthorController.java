package com.library.books.controller;

import com.library.books.model.Author;
import com.library.books.model.Book;
import com.library.books.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/authors")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping()
    public List<Author> retrieveAuthors() {
        return authorService.retrieveAuthors();
    }

    @GetMapping(path = "/{authorId}")
    public Author retrieveAuthorById(@PathVariable Long authorId) {
        return authorService.retrieveAuthorById(authorId);
    }

    @GetMapping(path = "/books/{authorId}")
    public List<Book> retrieveBooksByAuthorId(@PathVariable Long authorId) {
        return authorService.retrieveBooksAuthorById(authorId);
    }
}
