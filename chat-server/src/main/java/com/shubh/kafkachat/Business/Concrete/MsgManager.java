package com.shubh.kafkachat.Business.Concrete;

import com.shubh.kafkachat.Business.Abstract.MsgService;
import com.shubh.kafkachat.DataAccess.Concrete.PostgreSQL.abstracts.MsgDao;
import com.shubh.kafkachat.Entities.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MsgManager implements MsgService {

    private MsgDao msgDao;

    @Autowired
    public MsgManager(MsgDao msgDao) {
        this.msgDao = msgDao;
    }

    @Override
    public void add(Msg msg) {

    }

    @Override
    public List<Msg> getAll() {

        return msgDao.findAll();
    }
}
