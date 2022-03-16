package com.henricoleodra.springreactivemongoreactivestram.router;

import com.henricoleodra.springreactivemongoreactivestram.router.handler.PeopleHandler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration(proxyBeanMethods = false)
public class PeopleRouter {
    
    @Bean
    public RouterFunction<ServerResponse> peopleOperationRouter(PeopleHandler handler){
        return RouterFunctions.nest(
            RequestPredicates.path("/people"), 
                RouterFunctions.route(POST("").and(accept(MediaType.APPLICATION_JSON)), handler::addPeople));
    }
}
