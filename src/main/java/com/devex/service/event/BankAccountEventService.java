package com.devex.service.event;

import com.devex.domain.Event;
import com.devex.domain.EventType;
import com.devex.repository.BankAccountEventRepository;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.UUID;

@Singleton
public class BankAccountEventService {

    @Inject
    private BankAccountEventRepository eventRespository;


    public void withdrawSaldo(String id, double saldo) {
        addEvent(new Event(id, saldo, EventType.WITHDRAW));
    }

    public void depositSaldo(String id, double saldo) {
        addEvent(new Event(id, saldo, EventType.DEPOSIT));
    }

    public Event getLastEvent(String id) {
        return eventRespository.getLastEvent(id);
    }

    public String createAccount() {
        String id = UUID.randomUUID().toString();
        addEvent(new Event(id, 0.0,  EventType.CREATEACCOUNT));
        return id;
    }

    public List<Event> getEvents(String id) {
        return eventRespository.getEvents(id);
    }

    private void addEvent(Event event) {
        eventRespository.addEvent(event);
    }

    public List<String> getAllAccounts() {
        //TODO event who asked?
        return eventRespository.getAllAccounts();
    }
}
