package com.github.mattneufeld.showerthoughts.usecase;

import com.github.mattneufeld.showerthoughts.gateway.ShowerThoughtGateway;
import com.github.mattneufeld.showerthoughts.model.ShowerThought;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetShowerThoughtUseCase {

    private final ShowerThoughtGateway GATEWAY;

    /**
     * This is the constructor for the GetShowerThought use case.
     * @param gateway This is the implementation of the ShowerThoughtGateway interface to be provided by Spring Boot.
     */
    @Autowired
    public GetShowerThoughtUseCase(ShowerThoughtGateway gateway){
        this.GATEWAY = gateway;
    }

    /**
     * This method calls the implementation of getShowerThought defined by the gateway.
     * @param id The ID of the shower thought to be returned.
     * @return The shower thought at the requested ID.
     */
    public ShowerThought execute(Long id) {
        return GATEWAY.readShowerThought(id);
    }
}
