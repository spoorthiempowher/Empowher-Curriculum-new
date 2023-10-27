package com.library.books.controller;

import com.library.books.model.Author;
import com.library.books.model.Book;
import com.library.books.model.Location;
import com.library.books.service.AuthorService;
import com.library.books.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/locations")
@CrossOrigin(origins = "http://localhost:4200")
public class LocationController {

    private final LocationService locationService;

    @GetMapping()
    public List<Location> retrieveAuthors() {
        return locationService.retrieveLocations();
    }

}
