package com.devex.repository;

import com.devex.domain.Event;
import com.mongodb.client.*;
import com.mongodb.client.model.*;

import javax.inject.Singleton;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Singleton
public class BankAccountEventRepository {

    private final MongoDatabase database;

    public BankAccountEventRepository(MongoClient mongoClient) {
        database = mongoClient.getDatabase("BankAccountEvents");
    }

    public void addEvent(Event event){
        database.getCollection(event.getOwnerId(), Event.class).insertOne(event);
    }

    public List<Event> getEvents(String id) {
        FindIterable<Event> events = database.getCollection(id, Event.class).find();
        return StreamSupport.stream(events.spliterator(),false).collect(Collectors.toList());
    }

    public Event getLastEvent(String id) {
         return database.getCollection(id, Event.class)
                 .aggregate(Collections.singletonList(
                         Aggregates.sort(Sorts.descending("objectId"))
                 )).
                 first();
    }

    public List<String> getAllAccounts() {
        MongoIterable<String> collections = database.listCollectionNames();
        return StreamSupport.stream(collections.spliterator(), false).collect(Collectors.toList());
    }


}
