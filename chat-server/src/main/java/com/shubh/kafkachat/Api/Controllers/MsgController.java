package com.shubh.kafkachat.Api.Controllers;

import com.shubh.kafkachat.Business.Abstract.MsgService;
import com.shubh.kafkachat.Entities.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/msg")
public class MsgController {

    private MsgService msgService;


    @Autowired
    public MsgController(MsgService msgService) {
        this.msgService = msgService;
    }




    @GetMapping("/getall")
    public List<Msg> getAll(){
        return  msgService.getAll();
    }
}
