package com.devex.domain.event;

public class TransferSaldoEvent extends Event{

    private final long fromId;
    private final long toId;
    private final double amount;

    public TransferSaldoEvent(long fromId, long toId, double amount) {
        this.fromId = fromId;
        this.toId = toId;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return super.toString() + "TransferSaldoEvent{" +
                "fromId=" + fromId +
                ", toId=" + toId +
                ", amount=" + amount +
                '}';
    }
}
