package com.board.example.service;

import com.board.example.dto.Token;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

public class RabbitMqListener {

//    @RabbitListener(queues = "sample.queue")
//    public void receiveMessage(final Message message) {
//        String consumedMessage = message.toString();
//        System.out.println(" [x] Consumed  '" + consumedMessage + "'");
//    }


//    @RabbitListener(bindings = @QueueBinding( value = @Queue(name = "sample.queue"),
//            exchange = @Exchange(value = "sample.exchange", type = ExchangeTypes.TOPIC)))
//    public void consumerMessage(final Token token) {
//        String consumedMessage = token.getToken();
//        System.out.println(" [x] Consumed  '" + consumedMessage + "'");
//    }


}
