package com.bc.springboot.controller;

import com.bc.springboot.model.Account;
import com.bc.springboot.model.Blog;
import com.bc.springboot.service.AccountService;
import com.bc.springboot.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/account", produces = "application/json")
public class AccountController {
    @Autowired
    private AccountService accountService;

    public AccountController(){

    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable final int id) {
        return ResponseEntity.ok(accountService.getAccountById(id));
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAccount(){
        List<Account> allAccount = accountService.getAccount();
        return ResponseEntity.ok(allAccount);
    }

    @PostMapping
    public ResponseEntity<Account> create(@RequestBody final Account accountFromRequest) {
        Account account = new Account(accountFromRequest);
        accountService.AddAccount(account);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(accountService.getAccountById(account.getId())).toUri();
        return ResponseEntity.created(uri).body(account);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Account> put(@RequestBody final Account accountFromRequest, @PathVariable final int id) {
        Account account = new Account(accountFromRequest);
        account.setId(id);
        accountService.updateAccount(account);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(accountService.getAccountById(account.getId())).toUri();
        return ResponseEntity.created(uri).body(account);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<List<Account>> delete(@PathVariable final int id){
        accountService.deleteAccount(id);
        List<Account> allAccounts = accountService.getAccount();
        return ResponseEntity.ok(allAccounts);
    }
}

