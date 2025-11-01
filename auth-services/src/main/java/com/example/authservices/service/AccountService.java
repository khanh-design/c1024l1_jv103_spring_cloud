package com.example.authservices.service;

import com.example.authservices.entity.Account;
import com.example.authservices.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
/*
* Mục đích của thằng này là:
* đóng vai trò là lấy Account từ database lên converter qua thằng user (spring-security)
* tk security check
* */
@Service
@Transactional
public class AccountService implements UserDetailsService {
    @Autowired
    private AccountRepository accountRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(username);
        if (account == null) {
            throw new UsernameNotFoundException("no user");
        }

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        account.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role));
        });
        return new User(account.getUsername(), account.getPassword(), authorities);
    }
}
