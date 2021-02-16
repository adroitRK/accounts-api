package com.anz.accounts.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.anz.accounts.model.AccountDAO;
import com.anz.accounts.model.TransactionDAO;

public interface TransactionRepository extends
                                        CrudRepository<TransactionDAO, Long> {

    List<TransactionDAO> findByAccount(AccountDAO account);

}
