package com.shubh.kafkachat.DataAccess.Concrete.PostgreSQL.abstracts;

import com.shubh.kafkachat.Entities.Msg;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public  interface MsgDao extends JpaRepository<Msg,Integer> {


}
