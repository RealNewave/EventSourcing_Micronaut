package com.devex.domain.event;

public class AddSaldoToAccount extends Event{

    private final long id;
    private final double amount;

    public AddSaldoToAccount(long id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    @Override
    public String toString() {

        return super.toString() + "AddSaldoToAccount{" +
                "id=" + id +
                ", amount=" + amount +
                '}';
    }
}
