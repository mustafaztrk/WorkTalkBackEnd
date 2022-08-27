package com.shubh.kafkachat.core.Abstract;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public interface IEntityRepository<T> {

    ArrayList<T> GetAll() throws ExecutionException, InterruptedException;
    void Add(T entity) throws ExecutionException, InterruptedException;
    void Update(T entity);
    void Delete(T entity);

}