package com.example.notificationservices.service;

import com.example.notificationservices.model.MessageDTO;

public interface EmailService {
    void sendEmail(MessageDTO messageDTO);
}
