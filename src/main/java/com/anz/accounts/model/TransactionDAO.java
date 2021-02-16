package com.anz.accounts.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter@Getter
@Entity
@Table(name = "transactions")
public class TransactionDAO implements Serializable {

    private static final long serialVersionUID = 1946885383658283799L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @ManyToOne
    @JoinColumn(name = "accountNumber", nullable = false)
    private AccountDAO account;

    @Column(nullable = false)
    private Date valueDate;

    @Column(nullable = true)
    private Float debitAmount;

    @Column(nullable = true)
    private Float creditAmount;

    @Column(nullable = false, length = 6)
    private String transactionType;

    @Column(nullable = true, length = 30)
    private String transactionNarrative;
}
