package com.devex.domain.dto;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class TransferSaldoDTO {

    private final String fromId;
    private final String toId;
    private final double amount;

    public TransferSaldoDTO(String fromId, String toId, double amount) {
        this.fromId = fromId;
        this.toId = toId;
        this.amount = amount;
    }

    public String getFromId() {
        return fromId;
    }

    public String getToId() {
        return toId;
    }

    public double getAmount() {
        return amount;
    }
}
