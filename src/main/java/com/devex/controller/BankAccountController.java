package com.devex.controller;

import com.devex.domain.dto.TransferSaldoDTO;
import com.devex.service.BankAccountService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;

import javax.inject.Inject;
import javax.validation.Valid;

@Controller("/account")
public class BankAccountController {

    @Inject
    private BankAccountService bankAccountService;

    @Post("/create")
    public long createAccount() {
        return bankAccountService.createAccount();
    }

    @Post("/add/{id}/{saldo}")
    public void addSaldo(long id, double saldo) {
        bankAccountService.addSaldo(id, saldo);
    }

    @Post("/substract/{id}/{saldo}")
    public void substractSaldo(long id, double saldo) {
        bankAccountService.substractSaldo(id, saldo);
    }

    @Post(value = "/transfer", consumes = MediaType.APPLICATION_JSON)
    public void transferSaldo(@Body TransferSaldoDTO transferSaldoDTO){
        bankAccountService.transferSaldo(transferSaldoDTO);
    }

    @Get("/{id}")
    public double getSaldo(long id) {
        return bankAccountService.getSaldoById(id);
    }

    @Get("/events")
    public void getEvents(){
        bankAccountService.getEvents();
    }

}
