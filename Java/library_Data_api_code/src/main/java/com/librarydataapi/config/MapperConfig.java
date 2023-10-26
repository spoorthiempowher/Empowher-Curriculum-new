package com.librarydataapi.config;

import com.librarydataapi.service.mappers.AuthorServiceMapper;
import com.librarydataapi.service.mappers.BookServiceMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

	@Bean
	public BookServiceMapper bookServiceMapper() {

		return Mappers.getMapper(BookServiceMapper.class);
	}

	@Bean
	public AuthorServiceMapper authorServiceMapper() {

		return Mappers.getMapper(AuthorServiceMapper.class);
	}

}
