package com.esmay.software.controller;


import com.esmay.software.model.MessageEntity;
import com.esmay.software.service.MessageService;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageController {
    @Autowired
    private MessageService messageService;


    @GetMapping("/received")
    public ResponseEntity<?> receivedMessage() {
        List<MessageEntity> last = messageService.allMessage();
        if (last == null) {
            return ResponseEntity.ok("No message received yet.");
        }
        return ResponseEntity.ok(last);
    }

}
