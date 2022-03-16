package com.henricoleodra.springreactivemongoreactivestram.utils;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoCollection;
import com.mongodb.reactivestreams.client.MongoDatabase;

import org.bson.Document;
import org.json.JSONObject;
import org.reactivestreams.Publisher;

public class MongoDBStore {
    private MongoClient client;
    private MongoDatabase database;

    public MongoDBStore(){
        client = new MongoDBConnection().getClient();
        database = client.getDatabase("people");
    }

    public void insertDocument(JSONObject data) throws Exception{
        MongoCollection<Document> collection = database.getCollection("detail");
        Document document = new Document();
        for (String keyStr : data.keySet()) {
            Object keyValue = data.get(keyStr);
            document.append(keyStr, keyValue);
        }
        collection.insertOne(document);
    }
}
