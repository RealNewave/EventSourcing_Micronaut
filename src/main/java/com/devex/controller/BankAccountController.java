package com.devex.controller;

import com.devex.domain.Event;
import com.devex.domain.dto.TransferSaldoDTO;
import com.devex.service.BankAccountService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;

import javax.inject.Inject;
import java.util.List;

@Controller("/account")
public class BankAccountController {

    @Inject
    private BankAccountService bankAccountService;

    @Post("/create")
    public String createAccount() {
        return bankAccountService.createAccount();
    }

    @Post("/{id}/add/{saldo}")
    public void addSaldo( String id,  double saldo) {
        bankAccountService.addSaldo(id, saldo);
    }

    @Post("/{id}/subtract/{saldo}")
    public void subtractSaldo( String id,  double saldo) {
        bankAccountService.subtractSaldo(id, saldo);
    }

    @Post(value = "/transfer", consumes = MediaType.APPLICATION_JSON)
    public void transferSaldo(@Body TransferSaldoDTO transferSaldoDTO){
        bankAccountService.transferSaldo(transferSaldoDTO);
    }

    @Get("/{id}")
    public Event getLastEvent(String id) {
        return bankAccountService.getLastEvent(id);
    }

    @Get("/{id}/events")
    public List<Event> getEvents( String id){
        return bankAccountService.getEvents(id);
    }

}
