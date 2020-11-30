package com.devex.domain.event;

public class CreateBankAccount extends Event{

    private final long id;

    public CreateBankAccount(long id) {
        super();
        this.id = id;
    }

    @Override
    public String toString() {
        return super.toString() + "CreateBankAccount{" +
                "id=" + id +
                '}';
    }
}
