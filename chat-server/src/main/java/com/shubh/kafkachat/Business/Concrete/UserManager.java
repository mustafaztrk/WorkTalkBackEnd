package com.shubh.kafkachat.Business.Concrete;

import com.shubh.kafkachat.Business.Abstract.IUserService;
import com.shubh.kafkachat.core.Abstract.IUserDao;
import com.shubh.kafkachat.Entities.User;
import com.shubh.kafkachat.core.utilities.results.DataResult;
import com.shubh.kafkachat.core.utilities.results.Result;
import com.shubh.kafkachat.core.utilities.results.SuccessDataResult;
import com.shubh.kafkachat.core.utilities.results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

@Service
public class UserManager implements IUserService {
    IUserDao userService;

    @Autowired
    public UserManager(IUserDao userService) {
        this.userService = userService;
    }



    @Override
    public ArrayList<User> GetAll() throws ExecutionException, InterruptedException {
        return userService.GetAll() ;
    }

    @Override
    public DataResult<User> getByName(String name) throws ExecutionException, InterruptedException {
        return new SuccessDataResult<User>(userService.getByName(name));
    }


    @Override
    public Result add(User user) throws ExecutionException, InterruptedException {
        userService.Add(user);
        return new SuccessResult("Kullanıcı Eklendi.");
    }

    @Override
    public Result update(User entity) {
        return null;
    }

    @Override
    public Result delete(int id) {
        return null;
    }

    @Override
    public DataResult<ArrayList<User>> getAll() throws ExecutionException, InterruptedException {
        return new SuccessDataResult<ArrayList<User>>(userService.GetAll());
    }



}
