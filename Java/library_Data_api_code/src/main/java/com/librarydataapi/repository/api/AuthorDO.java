package com.librarydataapi.repository.api;

import lombok.Builder;
import lombok.Value;
import org.springframework.data.relational.core.mapping.Column;

@Value
@Builder
public class AuthorDO {

	@Column("authorId")
	Long authorId;

	@Column("authorName")
	String authorName;

	@Column("authorEmailId")
	String authorEmailId;

	@Column("description")
	String description;

}
