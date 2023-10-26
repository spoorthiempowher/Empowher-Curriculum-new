package com.librarydataapi.repository;

import com.librarydataapi.repository.api.BookDO;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface BookRepository extends ReactiveCrudRepository<BookDO, Long> {

	final class Queries {

		private Queries() {

		}

		// =============================================================================================================
		// GET: Book
		// =============================================================================================================

		private static final String SELECT_QUERY_BOOKS = """
															SELECT book.*, author.*, location.*
															FROM wiki.book book
															INNER JOIN wiki.author author
															ON book."authorId" = author."authorId"
															INNER JOIN wiki.location location
															ON book."locationId" = location."locationId"
														  """;

		private static final String SELECT_QUERY_SPECIFIC_BOOK = """
																    SELECT book.*, author.*, location.*
																    FROM wiki.book book
																    INNER JOIN wiki.author author
																    ON book."authorId" = author."authorId"
																    INNER JOIN wiki.location location
																    ON book."locationId" = location."locationId"
																 """;

		private static final String ORDER_BY_BOOKID = """
														 Order By book."bookId"
													  """;


	}

	@Query(Queries.SELECT_QUERY_BOOKS + Queries.ORDER_BY_BOOKID)
	Flux<BookDO> retrieveAllBooks();

	@Query(Queries.SELECT_QUERY_SPECIFIC_BOOK + " And book.\"bookId\" = :bookId ")
	Mono<BookDO> retrieveBookById(Long bookId);

	@Query(Queries.SELECT_QUERY_BOOKS + " And (book.\"bookName\" like :bookOrAuthorName OR author.\"authorName\" like :bookOrAuthorName) " + Queries.ORDER_BY_BOOKID)
	Flux<BookDO> bookOrAuthorNameContain(String bookOrAuthorName);

}
