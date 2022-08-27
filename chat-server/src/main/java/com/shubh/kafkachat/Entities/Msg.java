package com.shubh.kafkachat.Entities;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name="message")
public class Msg {
    @Id
    @GeneratedValue
    @Column(name="message_id")
    private  int id;
    @Column(name="sender")
    private String sender;
    @Column(name="content")
    private String content;
    @Column(name="timestamp")
    private String timestamp;


}
