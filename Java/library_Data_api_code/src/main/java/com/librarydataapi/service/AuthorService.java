package com.librarydataapi.service;

import com.librarydataapi.repository.AuthorRepository;
import com.librarydataapi.resource.api.AuthorRO;
import com.librarydataapi.service.mappers.AuthorServiceMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthorService {

	private final AuthorRepository authorRepository;

	private final AuthorServiceMapper authorServiceMapper;

	// =================================================================================================================
	// GET: Author
	// =================================================================================================================

	public Mono<AuthorRO> retrieveAuthorById(Long authorId) {

		return authorRepository.retrieveAuthorById(authorId)
				.map(authorServiceMapper::mapAuthorDOToAuthorRO);
	}

}
