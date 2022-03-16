package com.henricoleodra.springreactivemongoreactivestram.utils;

import com.mongodb.MongoException;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;

public class MongoDBConnection {
    private MongoClient client;

    public MongoDBConnection() throws MongoException {
        String host = "localhost";
        String port = "27017";

        // client = MongoClients.create("mongodb://" + host + ":" + port );
        client = MongoClients.create();
    }

    public MongoClient getClient() {
        return client;
    }
}
