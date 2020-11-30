package com.devex.service;

import com.devex.domain.dto.TransferSaldoDTO;
import com.devex.service.event.BankAccountEventService;
import com.devex.service.state.BankAccountStateService;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class BankAccountService {

    private long id = 1;

    @Inject
    private BankAccountStateService stateService;
    @Inject
    private BankAccountEventService eventService;


    public void substractSaldo(long id, double saldo) {
        eventService.substractSaldo(id, saldo);
        stateService.substractSaldo(id, saldo);
    }

    public void addSaldo(long id, double saldo) {
        eventService.addSaldo(id, saldo);
        stateService.addSaldo(id, saldo);
    }

    public double getSaldoById(long id) {
        double saldo = stateService.getSaldoById(id);
        eventService.getSaldoById(id, saldo);
        return saldo;
    }

    public long createAccount() {
        eventService.createAccount(id);
        stateService.createAccount(id);
        return id++;
    }

    public void getEvents(){
        eventService.getEvents();
    }

    public void transferSaldo(TransferSaldoDTO transferSaldoDTO) {
        long fromId = transferSaldoDTO.getFromId();
        long toId = transferSaldoDTO.getToId();
        double amount = transferSaldoDTO.getAmount();
        eventService.transferSaldo(fromId,toId,amount);
        addSaldo(toId, amount);
        substractSaldo(fromId, amount);
    }
}
