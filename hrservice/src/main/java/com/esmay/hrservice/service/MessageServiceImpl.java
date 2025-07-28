package com.esmay.hrservice.service;


import com.esmay.hrservice.model.MessageEntity;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService{
    private String exchange = "hr";
    private String routingKey = "hr";

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendMessage(MessageEntity message) {
        rabbitTemplate.convertAndSend(exchange,routingKey,message);
    }
}
