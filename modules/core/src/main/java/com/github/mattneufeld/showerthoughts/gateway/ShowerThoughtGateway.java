package com.github.mattneufeld.showerthoughts.gateway;

import com.github.mattneufeld.showerthoughts.exception.NotFoundException;
import com.github.mattneufeld.showerthoughts.model.ShowerThought;

public interface ShowerThoughtGateway {

    ShowerThought createShowerThought(ShowerThought thought);
    ShowerThought readShowerThought(Long id) throws NotFoundException;
    ShowerThought updateShowerThought(Long id, ShowerThought thought) throws NotFoundException;
    ShowerThought deleteShowerThought(Long id) throws NotFoundException;
}
