package com.librarydataapi.resource.api;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.With;
import org.springframework.data.relational.core.mapping.Column;

@Value
@Builder(toBuilder = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class BookRO {

	Long bookId;

	String bookName;

	Long bookPrice;

	String publisher;

	Long isbn;

	Long stockQuantity;

	Long authorId;

	Long locationId;

	String authorName;

	String blockNo;

	String baySide;

	String floorNo;

	String selfNo;

}
