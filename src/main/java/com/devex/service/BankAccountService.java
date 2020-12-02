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


    public void subtractSaldo(String id, double saldo) {
        eventService.subtractSaldo(id, saldo);
    }

    public void addSaldo(String id, double saldo) {
        eventService.addSaldo(id, saldo);
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
        subtractSaldo(fromId, amount);
        addSaldo(toId, amount);
    }
}
