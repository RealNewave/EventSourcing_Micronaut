package com.devex.service.state;

import com.devex.domain.BankAccount;
import com.devex.repository.BankAccountStateRespository;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.client.exceptions.HttpClientResponseException;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class BankAccountStateService {

    @Inject
    private BankAccountStateRespository bankAccountStateRespository;

    public void substractSaldo(long id, double saldo) {
        BankAccount account = getBankAccount(id);
        account.substractSaldo(saldo);
    }

    public void addSaldo(long id, double saldo) {
        BankAccount account = getBankAccount(id);
        account.addSaldo(saldo);
    }

    public double getSaldoById(long id) {
        BankAccount account = getBankAccount(id);
        return account.getSaldo();
    }

    public void createAccount(long id) {
        bankAccountStateRespository.bankAccounts.add(new BankAccount(id));
    }

    private BankAccount getBankAccount(long id) {
        return bankAccountStateRespository.bankAccounts.stream()
                .filter(bankAccount -> bankAccount.getId() == id)
                .findFirst()
                .orElseThrow(() -> new HttpClientResponseException("Not found", HttpResponse.notFound()));
    }
}
