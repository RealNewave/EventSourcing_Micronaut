package com.devex.service;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@MicronautTest
class BankAccountServiceTest {

    private long id = 1;

    @Test
    void createAccount() {
        Assertions.assertEquals(hi(), 1);
        Assertions.assertEquals(hi(), 2);
    }

    private long hi(){
        return id++;
    }
}