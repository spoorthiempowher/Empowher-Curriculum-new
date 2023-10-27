package com.library.books.repository;

import com.library.books.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    @Query("SELECT b FROM Book b WHERE b.name LIKE %:searchText% OR b.author.name LIKE %:searchText%")
    List<Book> searchByBookNameOrAuthorName(String searchText);
}
