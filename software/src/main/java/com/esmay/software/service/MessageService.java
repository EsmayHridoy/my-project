package com.esmay.software.service;


import com.esmay.software.model.MessageEntity;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;


public interface MessageService {


    void handleReceived(MessageEntity message); // called by RabbitListener
    MessageEntity getLastReceived();
}
