package com.anz.accounts.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.anz.accounts.exception.AccountsApplicationException;
import com.anz.accounts.model.Account;
import com.anz.accounts.model.Transaction;
import com.anz.accounts.service.AccountsService;

@RestController
public class AccountsController {

    private static final Logger LOG =
            LoggerFactory.getLogger(AccountsController.class);

    @Autowired
    private AccountsService service;

    @GetMapping("/{user}/accounts")
    public ResponseEntity<List<Account>> getAccounts(@PathVariable
            final String user) {
        LOG.info("Event: Initiating process to get accounts for user {}", user);
        try {
            List<Account> accountList = service.getAccountList(user);
            return new ResponseEntity<>(accountList, HttpStatus.OK);
        } catch (AccountsApplicationException ex) {
            LOG.error("Error: Request can't be processed !");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    ex.getMessage());
        }

    }

    @GetMapping("/{user}/accounts/{account}/transactions")
    public ResponseEntity<List<Transaction>> getTransactions(@PathVariable
            final String user, @PathVariable final Long account) {
        LOG.info("Event: Initiating process to get transactions for"
                + " account {}", account);
        try {
            List<Transaction> transactionList =
                    service.getAccountTransactions(user, account);
            return new ResponseEntity<>(transactionList, HttpStatus.OK);
        } catch (AccountsApplicationException ex) {
            LOG.error("Error: Request can't be processed !");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    ex.getMessage());
        }
    }
}
