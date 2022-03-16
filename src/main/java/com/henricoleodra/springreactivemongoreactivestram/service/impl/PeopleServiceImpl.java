package com.henricoleodra.springreactivemongoreactivestram.service.impl;

import com.henricoleodra.springreactivemongoreactivestram.service.PeopleService;
import com.henricoleodra.springreactivemongoreactivestram.utils.MongoDBStore;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service("PeopleService")
public class PeopleServiceImpl implements PeopleService {
    
    private MongoDBStore store;

    public PeopleServiceImpl(){
        store = new MongoDBStore();
    }

    @Override
    public void addPeople(JSONObject data){
        store.insertDocument(data);
    }
}
