package com.example.app.service.impl;

import com.example.app.dao.AccountDAO;
import com.example.app.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements UserDetailsService {

    @Autowired
    private AccountDAO accountDAO;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        Account account = accountDAO.findAccount(name);

        if (account == null){
            System.out.println("Account: " + null);
            throw new UsernameNotFoundException("Account " +
                    name + "không được tìm thấy trong Database.");

        }
        System.out.println("Account: " + account);

        /* Phân quyền */
        String role = account.getRole();
        List<GrantedAuthority> gantList = new ArrayList<>();
        GrantedAuthority authority = new SimpleGrantedAuthority(role);

        gantList.add(authority);

        boolean enabled = account.isActive();

        return new User(account.getName(),account.getPassword(), enabled,
                true,true,true, gantList);
    }
}
