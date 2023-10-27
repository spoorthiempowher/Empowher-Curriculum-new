package com.library.books.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Author {

    @Id
    @Column(name = "id")
    Long id;

    @Column(name = "name")
    String name;

    @Column(name = "email")
    String email;

    @Column(name = "description")
    String description;

    @JsonBackReference
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Book> books;
}