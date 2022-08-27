package com.shubh.kafkachat.Api.Controllers;


import com.shubh.kafkachat.Business.Abstract.IUserService;
import com.shubh.kafkachat.Entities.User;
import com.shubh.kafkachat.core.utilities.results.DataResult;
import com.shubh.kafkachat.core.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

@RestController
@CrossOrigin//tarıyıcı ve back-end arası güvensizlik çözer
@RequestMapping("/api")
public class UserControler {

    @Autowired
    private IUserService userService;

    @GetMapping("/user/getall")
    public DataResult<ArrayList<User>> GetAll()  throws ExecutionException, InterruptedException {
        return userService.getAll();
    }

    @PostMapping("/user/add")
    public Result add(@RequestBody User user) throws ExecutionException, InterruptedException {

        return userService.add(user);
    }

    @GetMapping("/user/getByUserName/{name}")
    public DataResult<User> getByUserName(@PathVariable String name) throws ExecutionException, InterruptedException {

        return userService.getByName(name);
    }

}
