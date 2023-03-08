package com.github.mattneufeld.showerthoughts.provider;

import com.github.mattneufeld.showerthoughts.exception.NotFoundException;
import com.github.mattneufeld.showerthoughts.gateway.ShowerThoughtGateway;
import com.github.mattneufeld.showerthoughts.model.ShowerThought;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Component
public class ShowerThoughtProvider implements ShowerThoughtGateway {

    private final HashMap<Long, String> THOUGHT_MAP = new HashMap<>();
    private long currentId = 0L;

    /**
     * This method is used to add a new shower thought to the database
     * @param thought This is the ShowerThought to be added to the database.
     * @return ShowerThought This returns the ShowerThought that was created with the ID changed to the database ID.
     */
    @Override
    public ShowerThought createShowerThought(ShowerThought thought) {
        while (THOUGHT_MAP.containsKey(currentId)) {
            currentId++;
        }
        thought.setId(currentId);
        THOUGHT_MAP.put(currentId++, thought.getThought());
        return thought;
    }

    /**
     * This method is the implementation to read a specific shower thought from the database.
     * @param id This is the id of the requested shower thought.
     * @return This is the shower thought at the specified ID.
     * @throws NotFoundException This exception indicates that the requested shower though id doesn't exist.
     */
    @Override
    public ShowerThought readShowerThought(Long id) throws NotFoundException {

        if (!THOUGHT_MAP.containsKey(id)) {
            throw new NotFoundException("Requested ID does not exist.");
        }

        ShowerThought thought = new ShowerThought();
        thought.setId(id);
        thought.setThought(THOUGHT_MAP.get(id));
        return thought;
    }

    /**
     * This method is the implementation to update the shower thought at a specific ID.
     * @param id This is the ID of the shower thought to be updated.
     * @param thought This is the shower thought to be updated to.
     * @return This is the shower thought that was added at the specified location.
     */
    @Override
    public ShowerThought updateShowerThought(Long id, ShowerThought thought){

        THOUGHT_MAP.put(id, thought.getThought());
        thought.setId(id);
        return thought;
    }

    /**
     * This method is the implementation to delete the shower thought at a specific ID.
     * @param id This is the ID of the shower thought to be deleted
     * @return This is the shower thought that was deleted.
     * @throws NotFoundException This exception indicates that the requested shower though ID doesn't exist.
     */
    @Override
    public ShowerThought deleteShowerThought(Long id) throws NotFoundException {

        if (!THOUGHT_MAP.containsKey(id)) {
            throw new NotFoundException("Requested ID to be deleted does not exist.");
        }

        ShowerThought thought = new ShowerThought();
        thought.setId(id);
        thought.setThought(THOUGHT_MAP.get(id));

        THOUGHT_MAP.remove(id);
        return thought;
    }

    /**
     * This method is the implementation to read all the currently stored shower thoughts.
     * @return A list of all the shower thoughts.
     */
    @Override
    public List<ShowerThought> readAllShowerThought() {
        ArrayList<ShowerThought> completeList = new ArrayList<>();
        THOUGHT_MAP.forEach((key, value) -> completeList.add(new ShowerThought(key, value)));
        return completeList;
    }
}
