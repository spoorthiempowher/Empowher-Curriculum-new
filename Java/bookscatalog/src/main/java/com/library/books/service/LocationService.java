package com.library.books.service;

import com.library.books.model.Author;
import com.library.books.model.Book;
import com.library.books.model.Location;
import com.library.books.repository.AuthorRepository;
import com.library.books.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationService {

    private final LocationRepository locationRepository;

    public List<Location> retrieveLocations() {
        return (List<Location>) this.locationRepository.findAll();
    }
}
