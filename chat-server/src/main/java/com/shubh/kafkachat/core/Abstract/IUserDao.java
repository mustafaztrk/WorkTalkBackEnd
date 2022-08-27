package com.shubh.kafkachat.core.Abstract;

import com.shubh.kafkachat.Entities.User;

import java.util.concurrent.ExecutionException;

public interface IUserDao extends IEntityRepository<User>{
    public User getByName( String name) throws ExecutionException, InterruptedException;
}
