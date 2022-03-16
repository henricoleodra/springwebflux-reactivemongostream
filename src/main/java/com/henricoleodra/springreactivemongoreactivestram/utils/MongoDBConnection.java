package com.henricoleodra.springreactivemongoreactivestram.utils;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;

public class MongoDBConnection {
    private MongoClient client;

    public MongoDBConnection() throws MongoException {
        ConnectionString connString = new ConnectionString(
            "mongodb://localhost:27017"
        );
        MongoClientSettings settings = MongoClientSettings.builder()
            .applyConnectionString(connString)
            .retryWrites(true)
            .build();
        client = MongoClients.create(settings);
    }

    public MongoClient getClient() {
        return client;
    }
}
