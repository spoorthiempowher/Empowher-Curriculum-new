package com.librarydataapi.repository;

import com.librarydataapi.repository.api.BookDO;
import com.librarydataapi.repository.helpers.BindSpecHelper;
import com.librarydataapi.repository.helpers.PreDeleteHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Repository
public class BookUpdateRepositoryImpl implements BookUpdateRepository {

    @Autowired
    private DatabaseClient dbClient;

    @Autowired
    private PreDeleteHelper preDeleteHelper;

    private static final String BOOK_ID = "bookId";
    private static final String BOOK_NAME = "bookName";
    private static final String BOOK_PRICE = "bookPrice";
    private static final String PUBLISHER = "publisher";
    private static final String ISBN = "isbn";
    private static final String STOCK_QUANTITY = "stockQuantity";
    private static final String AUTHOR_ID = "authorId";
    private static final String LOCATION_ID = "locationId";

    private static final String INSERT_BOOK_QUERY = """
                                                       INSERT INTO wiki.book("bookId",
                                                             "bookName",
                                                             "bookPrice",
                                                             "publisher",
                                                             "isbn",
                                                             "stockQuantity",
                                                             "authorId",
                                                             "locationId")
                                                       SELECT nextval('wiki."book_seq"'),
                                                             :bookName,
                                                             :bookPrice,
                                                             :publisher,
                                                             :isbn,
                                                             :stockQuantity,
                                                             :authorId,
                                                             :locationId
                                                       RETURNING "bookId"
                                                    """;

    private static final String INSERT_BOOK_QUERY_WITH_ID = """
                                                               INSERT INTO wiki.book("bookId",
                                                                     "bookName",
                                                                     "bookPrice",
                                                                     "publisher",
                                                                     "isbn",
                                                                     "stockQuantity",
                                                                     "authorId",
                                                                     "locationId")
                                                               SELECT :bookId,
                                                                     :bookName,
                                                                     :bookPrice,
                                                                     :publisher,
                                                                     :isbn,
                                                                     :stockQuantity,
                                                                     :authorId,
                                                                     :locationId
                                                             """;

    private static final String DELETE_BOOK_QUERY = """
                                                       DELETE FROM wiki.book where "bookId" = :bookId
                                                    """;

    // =================================================================================================================
    // Create: Book
    // =================================================================================================================

    @Modifying
    @Transactional
    public Mono<Long> insertBook(BookDO bookDO) {

        return new BindSpecHelper(dbClient.sql(INSERT_BOOK_QUERY))
                .bindIf(BOOK_NAME, bookDO.getBookName(), String.class)
                .bindIf(BOOK_PRICE, bookDO.getBookPrice(), Long.class)
                .bindIf(PUBLISHER, bookDO.getPublisher(), String.class)
                .bindIf(ISBN, bookDO.getIsbn(), Long.class)
                .bindIf(STOCK_QUANTITY, bookDO.getStockQuantity(), Long.class)
                .bindIf(AUTHOR_ID, bookDO.getAuthorId(), Long.class)
                .bindIf(LOCATION_ID, bookDO.getLocationId(), Long.class)

                .fetch()
                .one()
                .mapNotNull(row -> row.get(BOOK_ID))
                .cast(Integer.class)
                .map(Long::valueOf);
    }

    // =================================================================================================================
    // Update: Candidate
    // =================================================================================================================

    @Modifying
    @Transactional
    public Mono<Void> insertBook(Long bookId, BookDO bookDO) {

        return new BindSpecHelper(dbClient.sql(INSERT_BOOK_QUERY_WITH_ID))
                .bindIf(BOOK_ID, bookId, Long.class)
                .bindIf(BOOK_NAME, bookDO.getBookName(), String.class)
                .bindIf(BOOK_PRICE, bookDO.getBookPrice(), Long.class)
                .bindIf(PUBLISHER, bookDO.getPublisher(), String.class)
                .bindIf(ISBN, bookDO.getIsbn(), Long.class)
                .bindIf(STOCK_QUANTITY, bookDO.getStockQuantity(), Long.class)
                .bindIf(AUTHOR_ID, bookDO.getAuthorId(), Long.class)
                .bindIf(LOCATION_ID, bookDO.getLocationId(), Long.class)

                .fetchAndValidateUpdatedRowCount("insert-book", 1);
    }

    // =================================================================================================================
    // Delete: Book
    // =================================================================================================================

    @Modifying
    @Transactional
    public Mono<Void> deleteBookById(Long bookId) {

        return preDeleteHelper.runPreDelete("book")
                .then(new BindSpecHelper(dbClient.sql(DELETE_BOOK_QUERY))
                        .bindIf(BOOK_ID, bookId, Long.class)
                        .then());
    }

}
