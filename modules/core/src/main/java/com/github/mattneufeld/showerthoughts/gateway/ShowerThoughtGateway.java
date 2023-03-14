package com.github.mattneufeld.showerthoughts.gateway;

import com.github.mattneufeld.showerthoughts.exception.NotFoundException;
import com.github.mattneufeld.showerthoughts.model.ShowerThought;

import java.util.List;

/**
 * This interface defines the contract a shower thought provider must follow.
 */
public interface ShowerThoughtGateway {

    /**
     * This defines the function to create a new shower thought within the database.
     * @param thought The thought to be added to the database. Note that the id associated with this object is ignored
     *                and the provider uses its own id assignment logic for adding new thoughts.
     * @return The created shower thought with the id assigned to it by the provider.
     */
    ShowerThought createShowerThought(ShowerThought thought);
    ShowerThought readShowerThought(Long id) throws NotFoundException;

    /**
     * This defines the function to
     * @param id The id to be updated. If the id does not exist, a thought will be created with this id.
     * @param thought The thought to update the specified id with. Note that the id associated with this object is
     *                ignored and the id explicity defined in the function call will be used.
     * @return The shower thought created at the specified id.
     */
    ShowerThought updateShowerThought(Long id, ShowerThought thought);
    ShowerThought deleteShowerThought(Long id) throws NotFoundException;
    List<ShowerThought> readAllShowerThought();
}
