package com.github.mattneufeld.showerthoughts.rest.controller;

import com.github.mattneufeld.showerthoughts.core.model.ShowerThought;
import com.github.mattneufeld.showerthoughts.core.usecase.GetShowerThoughtUseCase;
import com.github.mattneufeld.showerthoughts.rest.mapper.ShowerThoughtMapper;
import com.github.mattneufeld.showerthoughts.rest.model.ShowerThoughtDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/showerthought")
public class ShowerThoughtController {

    private final GetShowerThoughtUseCase getShowerThoughtUseCase;

    @Autowired
    public ShowerThoughtController(GetShowerThoughtUseCase getShowerThoughtUseCase){
        this.getShowerThoughtUseCase = getShowerThoughtUseCase;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ShowerThoughtDto getShowerThought(@PathVariable Long id){
        ShowerThought thought = getShowerThoughtUseCase.execute(id);
        return ShowerThoughtMapper.INSTANCE.toDTO(thought);
    }

}
