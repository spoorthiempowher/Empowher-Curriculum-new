package com.library.books.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Entity
@NoArgsConstructor
@Data
public class Location {
    @Id
    @Column(name = "id")
    Long id;

    @Column(name = "block")
    String block;

    @Column(name = "bay_side")
    String bay_side;

    @Column(name = "floor")
    String floor;

    @Column(name = "shelf")
    String shelf;
}
