package com.example.account_service.controller;

import com.example.account_service.client.NotificationService;
import com.example.account_service.client.StatisticService;
import com.example.account_service.model.AccountDTO;
import com.example.account_service.model.MessageDTO;
import com.example.account_service.model.StatisticDTO;
import com.example.account_service.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private StatisticService statisticService;

    @Autowired
    private NotificationService notificationService;
    // add new
    @PostMapping("/account")
    public AccountDTO addAccount(@RequestBody AccountDTO accountDTO) {
        accountService.add(accountDTO);

        statisticService.add(new StatisticDTO("Account " + accountDTO.getName() + " is created", new Date()));

        //send notification
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setFrom("buiduykhanh0162003@gmail.com");
        messageDTO.setTo(accountDTO.getUsername()); // ussername is email
        messageDTO.setToName(accountDTO.getName());
        messageDTO.setSubject("Welcome to spring cloud");
        messageDTO.setContent("Khanh is online learning platfrom");

        notificationService.sendNotifications(messageDTO);
        return accountDTO;
    }

    // get all
    @GetMapping("/accounts")
    public List<AccountDTO> getAll() {
        return accountService.getAll();
    }

    @GetMapping("/account/{id}")
    public ResponseEntity<AccountDTO> get(@PathVariable(name = "id") Long id) {
        return Optional.of(new ResponseEntity<AccountDTO>(accountService.getOne(id), HttpStatus.OK))
                .orElse(new ResponseEntity<AccountDTO>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/account/{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        statisticService.add(new StatisticDTO("Delete account id " + id, new Date()));
        accountService.delete(id);
    }

    @PutMapping("/account")
    public void update(@RequestBody AccountDTO accountDTO) {
        statisticService.add(new StatisticDTO("Update account: " + accountDTO.getUsername(), new Date()));
        accountService.update(accountDTO);
    }
}
