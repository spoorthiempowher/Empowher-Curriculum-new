package com.librarydataapi.repository.api;

import lombok.Builder;
import lombok.Value;
import org.springframework.data.relational.core.mapping.Column;

@Value
@Builder
public class BookDO {

	@Column("bookId")
	Long bookId;

	@Column("bookName")
	String bookName;

	@Column("bookPrice")
	Long bookPrice;

	@Column("publisher")
	String publisher;

	@Column("isbn")
	Long isbn;

	@Column("stockQuantity")
	Long stockQuantity;

	@Column("authorId")
	Long authorId;

	@Column("locationId")
	Long locationId;

	@Column("authorName")
	String authorName;

	@Column("blockNo")
	String blockNo;

	@Column("baySide")
	String baySide;

	@Column("floorNo")
	String floorNo;

	@Column("selfNo")
	String selfNo;

}
