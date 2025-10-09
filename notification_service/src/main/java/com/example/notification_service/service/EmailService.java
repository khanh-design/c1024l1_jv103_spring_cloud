package com.example.notification_service.service;

import com.example.notification_service.model.MessageDTO;

public interface EmailService {
    void sendEmail(MessageDTO messageDTO);
}
