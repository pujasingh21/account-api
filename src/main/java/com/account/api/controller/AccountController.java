package com.account.api.controller;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import com.account.api.modal.Account;
import com.account.api.service.Accountservices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    Accountservices service;

    @PostMapping
    public ResponseEntity<Account> saveAccount(@Valid @RequestBody Account account) {
        return new ResponseEntity<>(service.saveAccountDetails(account), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Account>> fetchAccountDetails() {
        return new ResponseEntity<>(service.fetchAccountDetails(), HttpStatus.OK);
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<Account> fetchAccountDetails(@NotEmpty @PathVariable("accountId") @Min(1) Long id) {
        return new ResponseEntity<>(service.fetchAccountDetails(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Account> updateAccount(@Valid @RequestBody Account account) {
        return new ResponseEntity<>(service.saveAccountDetails(account), HttpStatus.OK);
    }

    @DeleteMapping("/{accountId}")
    public ResponseEntity<Account> deleteById(@Validated @PathVariable("accountId") @Min(1) Long id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
