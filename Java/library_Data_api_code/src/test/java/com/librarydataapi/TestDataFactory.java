package com.librarydataapi;

import java.util.List;

public abstract class TestDataFactory<R, M, D> {

    public abstract M getModelObject();

    public abstract List<M> getModelObjects();

    public abstract R getResourceObject();

    public abstract List<R> getResourceObjects();

    public abstract D getRepositoryObject();

    public abstract List<D> getRepositoryObjects();

}
