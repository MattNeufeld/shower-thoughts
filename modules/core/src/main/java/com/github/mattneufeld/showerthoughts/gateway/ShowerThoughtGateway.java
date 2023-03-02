package com.github.mattneufeld.showerthoughts.gateway;

import com.github.mattneufeld.showerthoughts.exception.NotFoundException;
import com.github.mattneufeld.showerthoughts.model.ShowerThought;

import java.util.List;

/**
 * This interface defines the contract a shower thought provider must follow.
 */
public interface ShowerThoughtGateway {

    ShowerThought createShowerThought(ShowerThought thought);
    ShowerThought readShowerThought(Long id) throws NotFoundException;
    ShowerThought updateShowerThought(Long id, ShowerThought thought);
    ShowerThought deleteShowerThought(Long id) throws NotFoundException;
    List<ShowerThought> readAllShowerThought();
}
