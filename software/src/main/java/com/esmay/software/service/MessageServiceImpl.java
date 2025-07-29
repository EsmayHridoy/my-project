package com.esmay.software.service;

import com.esmay.software.model.MessageEntity;
import com.esmay.software.repository.MessageRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;


@Service
public class MessageServiceImpl implements MessageService{
    private MessageRepository messageRepository;


    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    @RabbitListener(queues = {"hr"})
    public void handleReceived(MessageEntity message) {
        message.setId(null);
        System.out.println("Received: " + message);
        messageRepository.save(message);
    }

    public List<MessageEntity> allMessage(){
        return messageRepository.findAll();
    }

}
