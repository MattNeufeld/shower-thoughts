package com.github.mattneufeld.showerthoughts.usecase;

import com.github.mattneufeld.showerthoughts.gateway.ShowerThoughtGateway;
import com.github.mattneufeld.showerthoughts.model.ShowerThought;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateShowerThoughtUseCase {

    private final ShowerThoughtGateway GATEWAY;

    /**
     * This is the constructor for the UpdateShowerThought use case.
     * @param gateway This is the implementation of the ShowerThoughtGateway interface to be provided by Spring Boot.
     */
    @Autowired
    public UpdateShowerThoughtUseCase(ShowerThoughtGateway gateway) {
        this.GATEWAY = gateway;
    }

    /**
     * This method calls the implementation of createShowerThought defined by the gateway.
     * @param id This is the ID of the shower thought to be updated.
     * @param thought This is the new shower thought to be updated to.
     * @return The shower thought that was added at the specified ID.
     */
    public ShowerThought execute(Long id, ShowerThought thought) {
        return GATEWAY.updateShowerThought(id, thought);
    }
}
