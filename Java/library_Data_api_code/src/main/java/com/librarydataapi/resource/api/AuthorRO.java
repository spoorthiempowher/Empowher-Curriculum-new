package com.librarydataapi.resource.api;

import lombok.Builder;
import lombok.Value;
import org.springframework.data.relational.core.mapping.Column;

@Value
@Builder
public class AuthorRO {

	Long authorId;

	String authorName;

	String authorEmailId;

	String description;

}
