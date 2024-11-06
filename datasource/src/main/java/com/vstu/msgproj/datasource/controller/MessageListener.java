package com.vstu.msgproj.datasource.controller;

import com.vstu.msgproj.datasource.service.MessageService;
import com.vstu.msgproj.datasource.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Controller;

@Controller
public class MessageListener {

    @Autowired
    private MessageService messageService;

    @KafkaListener(topics = "test-topic", groupId = "my-group")
    public void listen(String message) {
        if (StringUtil.isBlank(message)){
            return;
        }
        messageService.saveMessage(message);
    }
}