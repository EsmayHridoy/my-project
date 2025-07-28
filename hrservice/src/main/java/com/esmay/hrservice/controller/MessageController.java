package com.esmay.hrservice.controller;


import com.esmay.hrservice.model.MessageEntity;
import com.esmay.hrservice.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/send")
    public ResponseEntity<?> sendMessage(@RequestBody MessageEntity message){
        messageService.sendMessage(message);
        return ResponseEntity.ok(message.toString()+" has been sent");
    }
}
