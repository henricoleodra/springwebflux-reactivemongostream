package com.henricoleodra.springreactivemongoreactivestram.utils;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoCollection;
import com.mongodb.reactivestreams.client.MongoDatabase;

import org.bson.Document;
import org.json.JSONObject;

public class MongoDBStore {
    private MongoClient client;
    private MongoDatabase database;

    public MongoDBStore(){
        client = new MongoDBConnection().getClient();
        database = client.getDatabase("Products");
    }

    public void insertDocument(JSONObject data){
        MongoCollection<Document> collection = database.getCollection("products");
        Document document = new Document();
        for (String keyStr : data.keySet()) {
            Object keyValue = data.get(keyStr);
            document.append(keyStr, keyValue);
        }
        collection.insertOne(document);
    }
}
