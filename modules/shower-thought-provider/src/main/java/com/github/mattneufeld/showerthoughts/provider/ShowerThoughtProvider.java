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

    private final HashMap<Long, String> BIG_DATA_BASE = new HashMap<>();
    private long currentId = 0L;

    /**
     * This method is used to add a new shower thought to the database
     * @param thought This is the ShowerThought to be added to the database.
     * @return ShowerThought This returns the ShowerThought that was created with the ID changed to the database ID.
     */
    @Override
    public ShowerThought createShowerThought(ShowerThought thought) {
        while (BIG_DATA_BASE.containsKey(currentId)) {
            currentId++;
        }
        thought.setId(currentId);
        BIG_DATA_BASE.put(currentId++, thought.getThought());
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

        if (!BIG_DATA_BASE.containsKey(id)) {
            throw new NotFoundException("Requested ID does not exist.");
        }

        ShowerThought thought = new ShowerThought();
        thought.setId(id);
        thought.setThought(BIG_DATA_BASE.get(id));
        return thought;
    }

    /**
     * This method is the implementation to update the shower thought at a specific ID
     * @param id This is the ID of the shower thought to be updated.
     * @param thought This is the shower thought to be updated to.
     * @return This is the shower thought that was added at the specified location.
     */
    @Override
    public ShowerThought updateShowerThought(Long id, ShowerThought thought){

        BIG_DATA_BASE.put(id, thought.getThought());
        thought.setId(id);
        return thought;
    }

    /**
     *
     * @param id
     * @return
     * @throws NotFoundException This exception indicates that the requested shower though id doesn't exist.
     */
    @Override
    public ShowerThought deleteShowerThought(Long id) throws NotFoundException {

        if (!BIG_DATA_BASE.containsKey(id)) {
            throw new NotFoundException("Requested ID to be deleted does not exist.");
        }

        ShowerThought thought = new ShowerThought();
        thought.setId(id);
        thought.setThought(BIG_DATA_BASE.get(id));

        BIG_DATA_BASE.remove(id);
        return thought;
    }

    @Override
    public List<ShowerThought> readAllShowerThought() {
        ArrayList<ShowerThought> completeList = new ArrayList<>();
        BIG_DATA_BASE.forEach((key,value) -> completeList.add(new ShowerThought(key, value)));
        return completeList;
    }
}
