package com.shubh.kafkachat.Business.Abstract;

import com.shubh.kafkachat.Entities.Msg;

import java.util.List;

public interface MsgService {

    void add(Msg msg);
    List<Msg> getAll();

}
