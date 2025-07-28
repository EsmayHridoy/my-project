package com.esmay.software.service;

import com.esmay.software.model.MessageEntity;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;


@Service
public class MessageServiceImpl implements MessageService{
    private MessageEntity lastMessage;

    @Override
    @RabbitListener(queues = "hr")
    public void handleReceived(MessageEntity message) {
        System.out.println("Received: " + message);
        this.lastMessage = message;
    }

    @Override
    public MessageEntity getLastReceived() {
        return lastMessage;
    }
}
