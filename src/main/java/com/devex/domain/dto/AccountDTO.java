package com.devex.domain.dto;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class AccountDTO {

    private final String id;

    public AccountDTO(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
