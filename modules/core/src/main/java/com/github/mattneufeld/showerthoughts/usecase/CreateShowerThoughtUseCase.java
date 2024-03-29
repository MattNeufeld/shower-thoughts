package com.github.mattneufeld.showerthoughts.usecase;

import com.github.mattneufeld.showerthoughts.gateway.ShowerThoughtGateway;
import com.github.mattneufeld.showerthoughts.model.ShowerThought;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateShowerThoughtUseCase {

    private final ShowerThoughtGateway GATEWAY;

    /**
     * This is the constructor for the CreateShowerThought use case.
     * @param gateway This is the implementation of the ShowerThoughtGateway interface to be provided by Spring Boot.
     */
    @Autowired
    public CreateShowerThoughtUseCase(ShowerThoughtGateway gateway){

        this.GATEWAY = gateway;
    }

    /**
     * This method calls the implementation of createShowerThought defined by the gateway.
     * @param thought This is the shower thought to be added to the database.
     * @return The shower thought after being added to the database.
     */
    public ShowerThought execute(ShowerThought thought) {

        return GATEWAY.createShowerThought(thought);
    }
}
