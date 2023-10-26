package com.librarydataapi.resource;

import com.librarydataapi.resource.api.BookRO;
import com.librarydataapi.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
@CrossOrigin(origins = "http://localhost:4200")
public class BookController {

	private final BookService bookService;

	// =================================================================================================================
	// GET: Book
	// =================================================================================================================

	@GetMapping(path = "/getAllBooks")
	public Flux<BookRO> retrieveAllBooks() {

		return bookService.retrieveAllBooks();

	}

	@GetMapping(path = "/getBookById/{bookId}")
	public Mono<BookRO> retrieveBookById(@PathVariable Long bookId) {

		return bookService.retrieveBookById(bookId);

	}

	@GetMapping(path = "/bookOrAuthorNameContain/{bookOrAuthorName}")
	public Flux<BookRO> bookOrAuthorNameContain(@PathVariable String bookOrAuthorName) {

		return bookService.bookOrAuthorNameContain(bookOrAuthorName);

	}

	// =================================================================================================================
	// Create: Book
	// =================================================================================================================

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(path = "/addBook")
	public Mono<BookRO> addBook(@RequestBody Mono<BookRO> bookROMono) {

		return bookService.addBook(bookROMono);

	}

	// =================================================================================================================
	// Update: Book
	// =================================================================================================================

	@PutMapping(path = "/updateBookById/{bookId}")
	public Mono<BookRO> updateBookById(@PathVariable Long bookId,
									  @RequestBody Mono<BookRO> bookROMono) {

		return bookService.updateBookById(bookId, bookROMono);

	}

	// =================================================================================================================
	// Delete: Book
	// =================================================================================================================

	@DeleteMapping(path = "/deleteBookById/{bookId}")
	public Mono<Void> deleteBookById(@PathVariable Long bookId) {

		return bookService.deleteBookById(bookId);

	}

}
