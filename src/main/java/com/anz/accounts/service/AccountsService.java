package com.anz.accounts.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anz.accounts.exception.AccountsApplicationException;
import com.anz.accounts.model.Account;
import com.anz.accounts.model.AccountDAO;
import com.anz.accounts.model.Transaction;
import com.anz.accounts.model.TransactionDAO;
import com.anz.accounts.repository.AccountRepository;
import com.anz.accounts.repository.TransactionRepository;

@Service
public class AccountsService {

    private static final Logger LOG =
            LoggerFactory.getLogger(AccountsService.class);

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    private Float accountBalance;

    @Transactional
    public List<AccountDAO> getAccountDetails(final String user) {
        return accountRepository.findByAccountUserIgnoreCase(user);
    }

    @Transactional
    public List<TransactionDAO> getTransactions(final AccountDAO account) {
        return transactionRepository.findByAccount(account);

    }

    @Transactional
    public List<Account> getAccountList(final String user)
            throws AccountsApplicationException {
        LOG.info("Event: Fetching all accounts for user {}", user);

        List<Account> accountList = null;
        List<AccountDAO> accountDaoList = getAccountDetails(user);

        if (accountDaoList.isEmpty()) {
            throw new AccountsApplicationException(
                    "No accounts found for the user !");
        } else {
            accountList = accountDaoList.stream()
                    .map(accountDao -> new Account(
                            accountDao.getAccountNumber(),
                            accountDao.getAccountName(),
                            accountDao.getAccountType(),
                            DateTimeFormatter.ofPattern("dd-MM-yyyy")
                                            .format(LocalDate.now()),
                            accountDao.getCurrency(),
                            getAccountBalance(accountDao)))
                    .collect(Collectors.toList());
        }

        return accountList;
    }

    private BigDecimal getAccountBalance(final AccountDAO account) {
        LOG.info("Event: Fetching all transaction for account {}",
                account.getAccountName());
        List<TransactionDAO> transactionDaoList = getTransactions(account);
        accountBalance = 0f;

        if (!transactionDaoList.isEmpty()) {
            transactionDaoList.stream()
            .forEach(transactionDao -> {
                if (transactionDao.getTransactionType().equals("Credit")) {
                    accountBalance += transactionDao.getCreditAmount();
                } else {
                    accountBalance -= transactionDao.getDebitAmount();
                }
            });
        }
        return BigDecimal.valueOf(accountBalance)
                .setScale(2, RoundingMode.HALF_EVEN);
    }

    @Transactional
    public List<Transaction> getAccountTransactions(final String user,
            final Long accountNumber) throws AccountsApplicationException {
        List<Account> accountList = getAccountList(user);

        if (accountList.isEmpty()) {
            LOG.error("Error: No user found{}!", user);
            throw new AccountsApplicationException("No user found!");
        }

        Optional<AccountDAO> optional =
                accountRepository.findById(accountNumber);
        if (!optional.isPresent()) {
            LOG.error("Error: No account found for the user {}!", user);
            throw new AccountsApplicationException(
                    "No account found for the user!");
        }

        AccountDAO accountDao = optional.get();
        List<TransactionDAO> transactionDaoList =
                transactionRepository.findByAccount(accountDao);

        if (transactionDaoList.isEmpty()) {
            LOG.error("Error: No transaction found for the account {}!",
                    accountNumber);
            throw new AccountsApplicationException(
                    "No transaction found for the account!");
        }

        return transactionDaoList.stream()
                .map(transactionDao -> new Transaction(
                        accountDao.getAccountNumber(),
                        accountDao.getAccountName(),
                        transactionDao.getValueDate(),
                        accountDao.getCurrency(),
                        transactionDao.getDebitAmount(),
                        transactionDao.getCreditAmount(),
                        transactionDao.getTransactionType(),
                        transactionDao.getTransactionNarrative())
                        )
                .collect(Collectors.toList());
    }
}
