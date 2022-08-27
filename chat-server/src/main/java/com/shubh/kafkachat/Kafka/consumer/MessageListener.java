package com.shubh.kafkachat.Kafka.consumer;

import com.shubh.kafkachat.DataAccess.Concrete.Firebase.MessageDao;
import com.shubh.kafkachat.Kafka.constants.KafkaConstants;
import com.shubh.kafkachat.Entities.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;

@Component
public class MessageListener {
    @Autowired
    private MessageDao messageService;
    @Autowired
    SimpMessagingTemplate template;


    Message mes=new Message();

    @KafkaListener(
            topics = KafkaConstants.KAFKA_TOPIC,
            groupId = KafkaConstants.GROUP_ID
    )
    public void listen(Message message) throws ExecutionException, InterruptedException {
        System.out.println("sending via kafka listener..");
        System.out.println(message);
        template.convertAndSend("/topic/group", message);
        mes=message;
        messageService.saveMessage(mes);
    }





}
