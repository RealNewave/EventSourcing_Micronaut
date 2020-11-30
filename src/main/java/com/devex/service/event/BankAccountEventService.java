package com.devex.service.event;

import com.devex.domain.event.*;
import com.devex.repository.BankAccountEventRespository;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class BankAccountEventService {

    @Inject
    private BankAccountEventRespository eventRespository;


    public void substractSaldo(long id, double saldo) {
        addEvent(new SubstractSaldoFromAccount(id, saldo));
    }

    public void addSaldo(long id, double saldo) {
        addEvent(new AddSaldoToAccount(id,  saldo));
    }

    public void getSaldoById(long id, double amount) {
        addEvent(new GetSaldoFromAccount(id, amount));
    }

    public void createAccount(long id) {
        addEvent(new CreateBankAccount(id));
    }

    public void getEvents() {
        eventRespository.getEvents();
    }

    public void transferSaldo(long fromId, long toId, double amount) {
        addEvent(new TransferSaldoEvent(fromId, toId, amount));
    }

    private void addEvent(Event event) {
        eventRespository.events.add(event);
    }

}
