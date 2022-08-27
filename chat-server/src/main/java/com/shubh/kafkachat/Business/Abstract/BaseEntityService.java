package com.shubh.kafkachat.Business.Abstract;

import com.shubh.kafkachat.core.utilities.results.DataResult;
import com.shubh.kafkachat.core.utilities.results.Result;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public interface BaseEntityService<T>{
    Result add(T entity) throws ExecutionException, InterruptedException;

    Result update(T entity);

    Result delete(int id);

    DataResult<ArrayList<T>> getAll() throws ExecutionException, InterruptedException;


}
