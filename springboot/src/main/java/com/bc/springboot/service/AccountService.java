package com.bc.springboot.service;

import com.bc.springboot.model.Account;
import com.bc.springboot.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private IAccountRepository iAccountRepository;

    public void AddAccount(Account account)
    {
        iAccountRepository.save(account);
    }

    public List<Account> getAccount()
    {
        return iAccountRepository.findAll();
    }

    public Account getAccountById(int id)
    {
        return iAccountRepository.findById(id).orElse(null);
    }

    public String deleteAccount(int id){
        iAccountRepository.deleteById(id);
        return "Object Deleted";
    }

    public Account updateAccount(Account account){
        Account accountData = iAccountRepository.findById(account.getId()).orElse(null);
        accountData.setBirthday(account.getBirthday());
        accountData.setCountry(account.getCountry());
        accountData.setFirstname(account.getFirstname());
        accountData.setLastname(account.getLastname());
        return iAccountRepository.save(accountData);
    }
}
