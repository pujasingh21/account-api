package com.account.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.account.api.modal.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.CannotCreateTransactionException;
import com.account.api.exception.DataBaseConnectionException;
import com.account.api.repository.accountrepository;
import com.account.api.exception.AccountNotFoundException;

@Service
public class Accountservices {

    @Autowired
    private accountrepository repository;

    public Account saveAccountDetails(Account accountData) {
        Account account = null;
        try {
            account = repository.save(account);
        } catch (CannotCreateTransactionException e) {
            throw new DataBaseConnectionException("Database server connection failure ", e);
        } catch (AccountNotFoundException e) {
            throw new AccountNotFoundException("Account not found", e);
        } catch (Exception e) {
            throw new AccountNotFoundException("Exception in Account @Post endpoint", e);
        }

        return account;
    }

    public List<Account> fetchAccountDetails() {
        List<Account> accounts = null;
        try {
            accounts = repository.findAll();
        } catch (CannotCreateTransactionException e) {
            throw new DataBaseConnectionException("Database server connection failure ", e);
        } catch (AccountNotFoundException e) {
            throw new AccountNotFoundException("Account not found", e);
        } catch (Exception e) {
            throw new AccountNotFoundException("Exception in Account @Get endpoint", e);
        }

        return accounts;
    }


    public Account fetchAccountDetails(Long id) {
        Optional<Account> account = null;
        try {
            account = repository.findById(id);
        } catch (CannotCreateTransactionException e) {
            throw new DataBaseConnectionException("Database server connection failure ", e);
        } catch (Exception e) {
            throw new AccountNotFoundException("Exception in Account @GetById Endpint", e);
        }
        return account.orElseThrow(() -> new AccountNotFoundException("Account id{} not found"));
    }

    public void deleteById(Long id) {
        try {
            repository.deleteById(id);
        } catch (CannotCreateTransactionException e) {
            throw new DataBaseConnectionException("Database server connection failure", e);
        } catch (EmptyResultDataAccessException e) {
            throw new AccountNotFoundException("Account id{} not found", e);
        } catch (Exception e) {
            throw new AccountNotFoundException("Exception in Account @Delete Endpoint", e);
        }

    }

}
