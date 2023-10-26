package com.librarydataapi;

import com.librarydataapi.repository.api.BookDO;
import com.librarydataapi.resource.api.BookRO;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BookTestDataFactory extends TestDataFactory<BookRO, BookDO, BookDO> {

    private final Integer END_INDEX = 10;

    @Override
    public BookDO getModelObject() {

        return createModelObject();
    }

    @Override
    public List<BookDO> getModelObjects() {

        return IntStream.range(0, END_INDEX)
                .mapToObj(index -> createModelObject())
                .collect(Collectors.toList());
    }

    private BookDO createModelObject() {

        return BookDO.builder()
                .build();
    }

    @Override
    public BookRO getResourceObject() {

        return createResourceObject();
    }

    @Override
    public List<BookRO> getResourceObjects() {

        return IntStream.range(0, END_INDEX)
                .mapToObj(index -> createResourceObject())
                .collect(Collectors.toList());
    }

    private BookRO createResourceObject() {

        return BookRO.builder()
                .build();
    }

    @Override
    public BookDO getRepositoryObject() {

        return createRepositoryObject();
    }

    @Override
    public List<BookDO> getRepositoryObjects() {

        return IntStream.range(0, END_INDEX)
                .mapToObj(index -> createRepositoryObject())
                .collect(Collectors.toList());
    }

    private BookDO createRepositoryObject() {

        return BookDO.builder()
                .build();
    }

}
