package com.devex.domain;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.client.exceptions.HttpClientResponseException;

public class BankAccount {

    private long id;
    private double saldo;

    public BankAccount(long id) {
        this.id = id;
        this.saldo = 0.0;
    }

    public long getId() {
        return id;
    }

    public void addSaldo(double amount) {
        if(amount <= 0.0){
            throw new HttpClientResponseException("Cant add negative amount", HttpResponse.badRequest());
        }
        saldo+=amount;
    }

    public void substractSaldo(double amount) {
        double newSaldo = saldo - amount;
        if(newSaldo < 0.0){
            throw new HttpClientResponseException("Not enough money to make request", HttpResponse.badRequest());
        }
        saldo = newSaldo;
    }

    public double getSaldo(){
        return saldo;
    }
}
