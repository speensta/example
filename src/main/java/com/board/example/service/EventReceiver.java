package com.board.example.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class EventReceiver {

    @RabbitListener(queues = "sample.queue")
    public void receiveMessage(final Message message) {
        String consumedMessage = message.toString();
        System.out.println(" [x] Consumed  '" + consumedMessage + "'");
    }

}
