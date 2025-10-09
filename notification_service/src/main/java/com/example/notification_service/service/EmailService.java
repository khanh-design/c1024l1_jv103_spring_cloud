package com.example.notification_service.service;

import com.example.notification_service.model.MessageDTO;

public interface MessageService {
    void sendEmail(MessageDTO messageDTO);
}
