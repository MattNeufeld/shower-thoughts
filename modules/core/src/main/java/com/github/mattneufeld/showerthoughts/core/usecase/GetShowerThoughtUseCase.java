package com.github.mattneufeld.showerthoughts.core.usecase;

import com.github.mattneufeld.showerthoughts.core.model.ShowerThought;
import org.springframework.stereotype.Component;

@Component
public class GetShowerThoughtUseCase {
    public ShowerThought execute(Long id) {
        ShowerThought thought = new ShowerThought();
        thought.setId(id);
        thought.setThought("These naming conventions ass");
        return thought;
    }
}
