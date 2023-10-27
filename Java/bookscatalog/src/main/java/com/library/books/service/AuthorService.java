package com.library.books.service;

import com.library.books.model.Author;
import com.library.books.model.Book;
import com.library.books.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public List<Author> retrieveAuthors() {
        return (List<Author>) authorRepository.findAll();
    }

    public Author retrieveAuthorById(Long authorId) {
        return authorRepository.findById(authorId).get();
    }

    public List<Book> retrieveBooksAuthorById(Long authorId) {
        Author author = authorRepository.findById(authorId).get();
        return author.getBooks();
    }
}
