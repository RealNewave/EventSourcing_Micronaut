package com.devex.domain.event;

public class GetSaldoFromAccount extends Event{

    private final long fromId;
    private final double amount;

    public GetSaldoFromAccount(long fromId, double amount) {
        this.fromId = fromId;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return super.toString() + " GetSaldoFromAccount{" +
                "fromId=" + fromId +
                ", amount=" + amount +
                '}';
    }
}
