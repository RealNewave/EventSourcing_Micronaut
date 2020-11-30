package com.devex.repository;

import com.devex.domain.BankAccount;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class BankAccountStateRespository {

    public List<BankAccount> bankAccounts = new ArrayList<>();

}
