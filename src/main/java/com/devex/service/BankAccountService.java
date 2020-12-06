package com.devex.service;

import com.devex.domain.dto.TransferSaldoDTO;
import com.devex.domain.Event;
import com.devex.service.event.BankAccountEventService;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class BankAccountService {

    @Inject
    private BankAccountEventService eventService;


    public void withdrawSaldo(String id, double saldo) {
        eventService.withdrawSaldo(id, saldo);
    }

    public void depositSaldo(String id, double saldo) {
        eventService.depositSaldo(id, saldo);
    }

    public Event getLastEvent(String id) {
        return eventService.getLastEvent(id);
    }

    public String createAccount() {
        return eventService.createAccount();
    }

    public List<Event> getEvents(String id){
        return eventService.getEvents(id);
    }

    public void transferSaldo(TransferSaldoDTO transferSaldoDTO) {
        String fromId = transferSaldoDTO.getFromId();
        String toId = transferSaldoDTO.getToId();
        double amount = transferSaldoDTO.getAmount();
        withdrawSaldo(fromId, amount);
        depositSaldo(toId, amount);
    }

    public List<String> getAllAccounts() {
        return eventService.getAllAccounts();
    }
}
