package com.example.notification_service.controller;

import com.example.notification_service.model.MessageDTO;
import com.example.notification_service.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send-notification")
    public void sendNotifications(@RequestBody MessageDTO messageDTO) {
        emailService.sendEmail(messageDTO);
    }
}
