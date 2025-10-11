package com.example.accountservices.controller;

import com.example.accountservices.client.NotificationService;
import com.example.accountservices.client.StatisticService;
import com.example.accountservices.model.AccountDTO;
import com.example.accountservices.model.MessageDTO;
import com.example.accountservices.model.StatisticDTO;
import com.example.accountservices.service.AccountService;
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

        statisticService.add(new StatisticDTO("Account " + accountDTO.getUsername() + "is create", new Date()));

        //send notification
        MessageDTO messageDTOs = new MessageDTO();
        messageDTOs.setFrom("buiduykhanh0162003@gmail.com");
        messageDTOs.setTo(accountDTO.getUsername()); //username is email
        messageDTOs.setToName(accountDTO.getName());
        messageDTOs.setSubject("Welcome to Spring cloud");
        messageDTOs.setContent("Spring cloud is online learning platfrom.");

        notificationService.sendNotification(messageDTOs);
        return accountDTO;
    }

    // get all
    @GetMapping("/accounts")
    public List<AccountDTO> getAll() {
        statisticService.add(new StatisticDTO("Get all accounts", new Date()));
        return accountService.getAll();
    }

    @GetMapping("/account/{id}")
    public ResponseEntity<AccountDTO> get(@PathVariable(name = "id") Long id) {
        return Optional.of(new ResponseEntity<AccountDTO>(accountService.getOne(id), HttpStatus.OK))
                .orElse(new ResponseEntity<AccountDTO>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/account/{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        statisticService.add(new StatisticDTO("Delete account id" + id, new Date()));
        accountService.delete(id);
    }

    @PutMapping("/account")
    public void update(@RequestBody AccountDTO accountDTO) {
        statisticService.add(new StatisticDTO("Update account: " + accountDTO.getUsername(), new Date()));
        accountService.update(accountDTO);
    }
}
