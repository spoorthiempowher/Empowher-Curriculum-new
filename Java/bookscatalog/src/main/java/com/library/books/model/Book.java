package com.library.books.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@Data
public class Book {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq")
    @SequenceGenerator(name = "book_seq", sequenceName = "book_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name")
    String name;

    @Column(name = "price")
    Long price;

    @Column(name = "publisher")
    String publisher;

    @Column(name = "isbn")
    Long isbn;

    @Column(name = "quantity")
    Long quantity;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @OneToOne
    @JoinColumn(name = "location_id")
    private Location location;
}