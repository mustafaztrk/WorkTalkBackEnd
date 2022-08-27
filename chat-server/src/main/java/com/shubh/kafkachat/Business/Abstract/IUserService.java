package com.shubh.kafkachat.Business.Abstract;

import com.shubh.kafkachat.Entities.User;
import com.shubh.kafkachat.core.utilities.results.DataResult;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public interface IUserService extends BaseEntityService<User> {
    ArrayList<User> GetAll() throws ExecutionException, InterruptedException;
    DataResult<User> getByName(String name) throws ExecutionException, InterruptedException;


}
