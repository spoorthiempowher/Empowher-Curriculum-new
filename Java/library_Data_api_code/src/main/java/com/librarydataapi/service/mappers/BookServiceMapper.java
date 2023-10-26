package com.librarydataapi.service.mappers;

import com.librarydataapi.repository.api.BookDO;
import com.librarydataapi.resource.api.BookRO;
import org.mapstruct.Mapper;

@Mapper(uses = { BookServiceMapper.class })
public interface BookServiceMapper {

	BookRO mapBookDOToBookRO(BookDO bookDO);

	BookDO mapBookROToBookDO(BookRO bookRO);

}
