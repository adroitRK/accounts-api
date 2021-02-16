package com.anz.accounts.model;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter@Getter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Transaction {

    private Long accountNumber;
    private String accountName;
    private Date valueDate;
    private String currency;
    private double debitAmount;
    private double creditAmount;
    private String transactionType;
    private String transactionNarrative;

}
