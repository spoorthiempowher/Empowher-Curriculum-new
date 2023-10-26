package com.librarydataapi.service.mappers;

import com.librarydataapi.repository.api.AuthorDO;
import com.librarydataapi.resource.api.AuthorRO;
import org.mapstruct.Mapper;

@Mapper(uses = { AuthorServiceMapper.class })
public interface AuthorServiceMapper {

	AuthorRO mapAuthorDOToAuthorRO(AuthorDO authorDO);

	AuthorDO mapAuthorROToAuthorDO(AuthorRO authorRO);

}
