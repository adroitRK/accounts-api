package com.anz.accounts.model;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter@Getter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Account {

    private Long accountNumber;
    private String accountName;
    private String accountType;
    private String balanceDate;
    private String currency;
    private BigDecimal balance;

}
