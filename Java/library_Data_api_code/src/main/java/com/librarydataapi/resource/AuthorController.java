package com.librarydataapi.resource;

import com.librarydataapi.resource.api.AuthorRO;
import com.librarydataapi.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/author")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthorController {

	private final AuthorService authorService;

	// =================================================================================================================
	// GET: Author
	// =================================================================================================================

	@GetMapping(path = "/getAuthorById/{authorId}")
	public Mono<AuthorRO> retrieveAuthorById(@PathVariable Long authorId) {

		return authorService.retrieveAuthorById(authorId);

	}

}
