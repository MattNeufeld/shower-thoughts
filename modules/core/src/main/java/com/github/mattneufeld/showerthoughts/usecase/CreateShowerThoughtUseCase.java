package com.github.mattneufeld.showerthoughts.usecase;

import com.github.mattneufeld.showerthoughts.gateway.ShowerThoughtGateway;
import com.github.mattneufeld.showerthoughts.model.ShowerThought;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateShowerThoughtUseCase {

    private final ShowerThoughtGateway GATEWAY;

    @Autowired
    public CreateShowerThoughtUseCase(ShowerThoughtGateway gateway){
        this.GATEWAY = gateway;
    }
    public ShowerThought execute(ShowerThought thought) {
        return GATEWAY.createShowerThought(thought);
    }
}
