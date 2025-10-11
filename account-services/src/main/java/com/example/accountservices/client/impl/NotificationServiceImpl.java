package com.example.accountservices.client.impl;

import com.example.accountservices.client.NotificationService;
import com.example.accountservices.model.MessageDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class NotificationServiceImpl implements NotificationService {
    Logger logger = LoggerFactory.getLogger(NotificationServiceImpl.class);
    @Override
    public void sendNotification(MessageDTO messageDTO) {
        //write fallback
        logger.error("Sending notification not fount");
    }
}
