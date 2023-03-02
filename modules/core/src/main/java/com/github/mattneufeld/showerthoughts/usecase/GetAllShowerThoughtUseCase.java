package com.github.mattneufeld.showerthoughts.usecase;

import com.github.mattneufeld.showerthoughts.gateway.ShowerThoughtGateway;
import com.github.mattneufeld.showerthoughts.model.ShowerThought;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllShowerThoughtUseCase {

    private final ShowerThoughtGateway GATEWAY;

    /**
     * This is the constructor for the GetShowerThought use case.
     * @param gateway This is the implementation of the ShowerThoughtGateway interface to be provided by Spring Boot.
     */
    @Autowired
    public GetAllShowerThoughtUseCase(ShowerThoughtGateway gateway){
        this.GATEWAY = gateway;
    }

    /**
     * This method calls the implementation of getShowerThought defined by the gateway.
     * @return The shower thought at the requested ID.
     */
    public List<ShowerThought> execute() {
        return GATEWAY.readAllShowerThought();
    }
}
