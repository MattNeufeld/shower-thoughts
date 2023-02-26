package com.github.mattneufeld.showerthoughts.usecase;

import com.github.mattneufeld.showerthoughts.gateway.ShowerThoughtGateway;
import com.github.mattneufeld.showerthoughts.model.ShowerThought;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetShowerThoughtUseCase {

    private final ShowerThoughtGateway GATEWAY;

    @Autowired
    public GetShowerThoughtUseCase(ShowerThoughtGateway gateway){
        this.GATEWAY = gateway;
    }
    public ShowerThought execute(Long id) {
        return GATEWAY.readShowerThought(id);
    }
}
