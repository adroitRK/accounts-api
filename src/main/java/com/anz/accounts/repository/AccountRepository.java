package com.anz.accounts.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.anz.accounts.model.AccountDAO;

public interface AccountRepository extends CrudRepository<AccountDAO, Long> {

    List<AccountDAO> findByAccountUserIgnoreCase(String accountUser);

}
