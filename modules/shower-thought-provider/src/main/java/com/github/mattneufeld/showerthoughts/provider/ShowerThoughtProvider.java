package com.github.mattneufeld.showerthoughts.provider;

import com.github.mattneufeld.showerthoughts.exception.NotFoundException;
import com.github.mattneufeld.showerthoughts.gateway.ShowerThoughtGateway;
import com.github.mattneufeld.showerthoughts.model.ShowerThought;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class ShowerThoughtProvider implements ShowerThoughtGateway {

    private final HashMap<Long, String> BIG_DATA_BASE = new HashMap<>();
    private long CURRENT_ID = 0L;

    @Override
    public ShowerThought createShowerThought(ShowerThought thought) {
        thought.setId(CURRENT_ID);
        BIG_DATA_BASE.put(CURRENT_ID++, thought.getThought());
        return thought;
    }

    @Override
    public ShowerThought readShowerThought(Long id) {

        if (!BIG_DATA_BASE.containsKey(id)) {
            throw new NotFoundException("Skill issue");
        }

        ShowerThought thought = new ShowerThought();
        thought.setId(id);
        thought.setThought(BIG_DATA_BASE.get(id));
        return thought;
    }

    @Override
    public ShowerThought updateShowerThought(Long id, ShowerThought thought) {

        if (!BIG_DATA_BASE.containsKey(id)) {
            throw new NotFoundException("Skill issue");
        }

        BIG_DATA_BASE.put(id, thought.getThought());
        thought.setId(id);

        return thought;
    }

    @Override
    public ShowerThought deleteShowerThought(Long id) {

        if (!BIG_DATA_BASE.containsKey(id)) {
            throw new NotFoundException("Skill issue");
        }

        ShowerThought thought = new ShowerThought();
        thought.setId(id);
        thought.setThought(BIG_DATA_BASE.get(id));

        BIG_DATA_BASE.remove(id);
        return thought;
    }
}
