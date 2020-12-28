package com.devex.controller;

import com.devex.domain.Event;
import com.devex.domain.dto.AccountDTO;
import com.devex.domain.dto.TransferSaldoDTO;
import com.devex.service.BankAccountService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Controller("/account")
public class BankAccountController {

    @Inject
    private BankAccountService bankAccountService;

    @Get
    public List<AccountDTO> getAllAccounts(){
        return bankAccountService.getAllAccounts()
                .stream()
                .map(AccountDTO::new)
                .collect(Collectors.toList());
    }

    @Get("/{id}")
    public Event getLastEvent(String id) {
        return bankAccountService.getLastEvent(id);
    }

    @Get("/{id}/events")
    public List<Event> getEvents( String id){
        return bankAccountService.getEvents(id);
    }

    @Post("/create")
    public AccountDTO createAccount() {
        return new AccountDTO(bankAccountService.createAccount());
    }

    @Post("/{id}/deposit/{saldo}")
    public void depositSaldo( String id, double saldo) {
        bankAccountService.depositSaldo(id, saldo);
    }

    @Post("/{id}/withdraw/{saldo}")
    public void withdrawSaldo( String id,  double saldo) {
        bankAccountService.withdrawSaldo(id, saldo);
    }

    @Post(value = "/transfer", consumes = MediaType.APPLICATION_JSON)
    public void transferSaldo(@Body TransferSaldoDTO transferSaldoDTO){
        bankAccountService.transferSaldo(transferSaldoDTO);
    }


}
