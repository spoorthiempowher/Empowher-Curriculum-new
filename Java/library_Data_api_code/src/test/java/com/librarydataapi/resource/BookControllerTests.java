package com.librarydataapi.resource;

import com.librarydataapi.BookTestDataFactory;
import com.librarydataapi.resource.api.BookRO;
import com.librarydataapi.service.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

import static org.mockito.Mockito.when;

@WithMockUser
@ExtendWith(MockitoExtension.class)
@WebFluxTest(BookController.class)
class BookControllerTests {

	@Autowired
	private WebTestClient client;

	@MockBean
	private BookService mockBookService;

	private final BookTestDataFactory bookTestDataFactory = new BookTestDataFactory();

	// =================================================================================================================
	// GET: Book
	// =================================================================================================================

	@Test
	void test_retrieveAllBooks() {

		// Given
		Long anyCandidateId = bookTestDataFactory.getModelObject().getBookId();
		BookRO anyBookRO = bookTestDataFactory.getResourceObject();

		when(mockBookService.retrieveAllBooks()).thenReturn(Flux.just(anyBookRO));

		// When
		client.get()
				.uri(uriBuilder -> uriBuilder
						.path("/book/getAllBooks/{bookId}")
						.build(anyCandidateId))
				.exchange()
				.expectStatus()
				.isOk()
				.expectBodyList(BookRO.class)
				.contains(anyBookRO);
	}

}
