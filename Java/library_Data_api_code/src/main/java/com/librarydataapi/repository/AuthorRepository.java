package com.librarydataapi.repository;

import com.librarydataapi.repository.api.AuthorDO;
import com.librarydataapi.repository.api.BookDO;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface AuthorRepository extends ReactiveCrudRepository<BookDO, Long> {

	final class Queries {

		private Queries() {

		}

		// =============================================================================================================
		// GET: Author
		// =============================================================================================================

		private static final String SELECT_QUERY_SPECIFIC_AUTHOR = """
																      SELECT author.*
																      FROM wiki.author author
																 	""";

	}

	@Query(Queries.SELECT_QUERY_SPECIFIC_AUTHOR + " WHERE author.\"authorId\" = :authorId ")
	Mono<AuthorDO> retrieveAuthorById(Long authorId);

}
