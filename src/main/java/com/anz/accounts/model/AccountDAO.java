package com.anz.accounts.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter@Getter
@Entity
@Table(name = "accounts")
public class AccountDAO implements Serializable {

    private static final long serialVersionUID = -3852313142579547764L;

    @Id
    @Column(length = 12)
    private Long accountNumber;

    @Column(nullable = false, length = 20)
    private String accountName;

    @Column(nullable = false, length = 20)
    private String accountType;

    @Column(nullable = false, length = 3)
    private String currency;

    @Column(nullable = false, length = 20)
    private String accountUser;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL,
                                     fetch = FetchType.LAZY)
    private List<TransactionDAO> transactions;
}
