package com.example.account_service.client;

import com.example.account_service.model.MessageDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "notification-service", url = "http://localhost:9083")
public interface NotificationService {

    @PostMapping("/send-notification")
    void sendNotifications(@RequestBody MessageDTO messageDTO);
}
