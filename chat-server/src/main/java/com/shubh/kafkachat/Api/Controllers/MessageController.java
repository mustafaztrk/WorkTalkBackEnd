package com.shubh.kafkachat.Api.Controllers;


import com.shubh.kafkachat.DataAccess.Concrete.Firebase.MessageDao;
import com.shubh.kafkachat.Entities.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@CrossOrigin//tarıyıcı ve back-end arası güvensizlik çözer
@RequestMapping("/api")

public class MessageController {

    @Autowired
    private MessageDao messageService;



    @PostMapping("/message/add")
    public String saveMessages(@RequestBody Message message) throws ExecutionException, InterruptedException {

        return messageService.saveMessage(message);
    }



    @GetMapping("/message/getall")
    public List<Message> getAllProducts() throws ExecutionException, InterruptedException {

        return messageService.getMessageDetails();
    }






}
