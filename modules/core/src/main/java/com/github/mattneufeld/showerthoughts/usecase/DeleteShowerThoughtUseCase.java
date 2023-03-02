package com.github.mattneufeld.showerthoughts.usecase;

import com.github.mattneufeld.showerthoughts.gateway.ShowerThoughtGateway;
import com.github.mattneufeld.showerthoughts.model.ShowerThought;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteShowerThoughtUseCase {

    private final ShowerThoughtGateway GATEWAY;

    /**
     * This is the constructor for the DeleteShowerThought use case.
     * @param gateway This is the implementation of the ShowerThoughtGateway interface to be provided by Spring Boot.
     */
    @Autowired
    public DeleteShowerThoughtUseCase(ShowerThoughtGateway gateway){
        this.GATEWAY = gateway;
    }

    /**
     * This method calls the implementation of deleteShowerThought defined by the gateway.
     * @param id This is the ID of the shower thought to be deleted.
     * @return The shower thought that was deleted.
     */
    public ShowerThought execute(Long id) {
        return GATEWAY.deleteShowerThought(id);
    }
}
