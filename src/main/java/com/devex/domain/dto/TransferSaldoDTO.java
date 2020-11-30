package com.devex.domain.dto;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class TransferSaldoDTO {

    private final long fromId;
    private final long toId;
    private final double amount;

    public TransferSaldoDTO(long fromId, long toId, double amount) {
        this.fromId = fromId;
        this.toId = toId;
        this.amount = amount;
    }

    public long getFromId() {
        return fromId;
    }

    public long getToId() {
        return toId;
    }

    public double getAmount() {
        return amount;
    }
}
