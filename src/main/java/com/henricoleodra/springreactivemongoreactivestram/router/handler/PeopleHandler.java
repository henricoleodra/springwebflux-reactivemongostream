package com.henricoleodra.springreactivemongoreactivestram.router.handler;

import com.henricoleodra.springreactivemongoreactivestram.service.PeopleService;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@Component
public class PeopleHandler {  
    
    @Autowired
    private PeopleService service;

    public Mono<ServerResponse> addPeople(ServerRequest request){
        Mono<String> bodyString = request.bodyToMono(String.class);
        return bodyString.flatMap(body -> {
            JSONObject requestBody = new JSONObject(body);
            service.addPeople(requestBody);
            return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue("Success");
        });
    }
}
