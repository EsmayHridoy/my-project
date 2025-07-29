package com.esmay.software.service;


import com.esmay.software.model.MessageEntity;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.List;


public interface MessageService {


    void handleReceived(MessageEntity message); // called by RabbitListener
    public List<MessageEntity> allMessage();
}
