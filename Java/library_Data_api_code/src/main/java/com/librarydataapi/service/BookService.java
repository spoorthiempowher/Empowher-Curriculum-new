package com.librarydataapi.service;

import com.librarydataapi.repository.BookRepository;
import com.librarydataapi.repository.BookUpdateRepository;
import com.librarydataapi.resource.api.BookRO;
import com.librarydataapi.service.mappers.BookServiceMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookService {

	private final String DOLLAR_SIGN = "%";

	private final BookRepository bookRepository;

	private final BookUpdateRepository bookUpdateRepository;

	private final BookServiceMapper bookServiceMapper;

	// =================================================================================================================
	// GET: Book (Consolidated Object)
	// =================================================================================================================

	public Flux<BookRO> retrieveAllBooks() {

		return bookRepository.retrieveAllBooks()
				.map(bookServiceMapper::mapBookDOToBookRO);
	}

	public Mono<BookRO> retrieveBookById(Long bookId) {

		return bookRepository.retrieveBookById(bookId)
				.map(bookServiceMapper::mapBookDOToBookRO);
	}

	public Flux<BookRO> bookOrAuthorNameContain(String bookOrAuthorName) {

		String patternToSearch = DOLLAR_SIGN + bookOrAuthorName + DOLLAR_SIGN;

		return bookRepository.bookOrAuthorNameContain(patternToSearch)
				.map(bookServiceMapper::mapBookDOToBookRO);
	}

	// =================================================================================================================
	// Create: Book
	// =================================================================================================================

	public Mono<BookRO> addBook(Mono<BookRO> bookROMono) {

		Mono<BookRO> cachedBook = bookROMono.cache();

		return cachedBook.map(bookServiceMapper::mapBookROToBookDO)
				.flatMap(bookUpdateRepository::insertBook)
				.flatMap(this::retrieveBookById);
	}

	// =================================================================================================================
	// Update: Book
	// =================================================================================================================

	public Mono<BookRO> updateBookById(Long bookId, Mono<BookRO> bookROMono) {

		Mono<BookRO> cachedBook = bookROMono.cache();

		return bookUpdateRepository.deleteBookById(bookId)
				.then(cachedBook.map(bookServiceMapper::mapBookROToBookDO))
				.flatMap(bookDO -> bookUpdateRepository.insertBook(bookId, bookDO))
				.then(this.retrieveBookById(bookId));
	}

	// =================================================================================================================
	// Delete: Book
	// =================================================================================================================

	public Mono<Void> deleteBookById(Long bookId) {

		return bookUpdateRepository.deleteBookById(bookId);
	}

}
