package com.devex.repository;

import com.devex.domain.event.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;
import java.util.LinkedList;
import java.util.List;


@Singleton
public class BankAccountEventRespository {

    private Logger log = LoggerFactory.getLogger(BankAccountEventRespository.class);

    public List<Event> events = new LinkedList<>();


    public void getEvents() {
        log.info(String.valueOf(events));
    }
}
