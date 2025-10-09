package com.example.account_service.service;

import com.example.account_service.model.AccountDTO;

import java.util.List;

public interface AccountService {
    void add(AccountDTO accountDTO);

    void update(AccountDTO accountDTO);

    void updatePassword(AccountDTO accountDTO);

    void delete(Long id);

    List<AccountDTO> getAll();

    AccountDTO getOne(Long id);
}
