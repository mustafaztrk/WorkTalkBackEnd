package com.shubh.kafkachat.Api.Controllers;


import com.shubh.kafkachat.DataAccess.Concrete.Firebase.UserDao;

import com.shubh.kafkachat.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@CrossOrigin//tarıyıcı ve back-end arası güvensizlik çözer
@RequestMapping("/api")
public class UserControler2 {
    @Autowired
    private UserDao userService;



    @PostMapping("/user2/add")
    public String saveProduct(@RequestBody User user) throws ExecutionException, InterruptedException {

        return userService.saveUser(user);
    }

    @GetMapping("/user2/getall")
    public List<User> getAllUsers() throws ExecutionException, InterruptedException {

        return userService.getUserDetails();
    }
    @GetMapping("/user2/getByUserName/{name}")
    public User getByUserName(@PathVariable String name) throws ExecutionException, InterruptedException {

        return userService.getUserDetailsByName(name);
    }





}
