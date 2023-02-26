package com.github.mattneufeld.showerthoughts.controller;

import com.github.mattneufeld.showerthoughts.model.ShowerThought;
import com.github.mattneufeld.showerthoughts.usecase.CreateShowerThoughtUseCase;
import com.github.mattneufeld.showerthoughts.usecase.DeleteShowerThoughtUseCase;
import com.github.mattneufeld.showerthoughts.usecase.GetShowerThoughtUseCase;
import com.github.mattneufeld.showerthoughts.mapper.ShowerThoughtMapper;
import com.github.mattneufeld.showerthoughts.model.ShowerThoughtDto;
import com.github.mattneufeld.showerthoughts.usecase.UpdateShowerThoughtUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/showerthought")
public class ShowerThoughtController {

    private final GetShowerThoughtUseCase getShowerThoughtUseCase;
    private final CreateShowerThoughtUseCase createShowerThoughtUseCase;
    private final UpdateShowerThoughtUseCase updateShowerThoughtUseCase;
    private final DeleteShowerThoughtUseCase deleteShowerThoughtUseCase;

    @Autowired
    public ShowerThoughtController(
            GetShowerThoughtUseCase getShowerThoughtUseCase,
            CreateShowerThoughtUseCase createShowerThoughtUseCase,
            DeleteShowerThoughtUseCase deleteShowerThoughtUseCase,
            UpdateShowerThoughtUseCase updateShowerThoughtUseCase){
        this.getShowerThoughtUseCase = getShowerThoughtUseCase;
        this.createShowerThoughtUseCase = createShowerThoughtUseCase;
        this.updateShowerThoughtUseCase = updateShowerThoughtUseCase;
        this.deleteShowerThoughtUseCase = deleteShowerThoughtUseCase;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ShowerThoughtDto getShowerThought(@PathVariable Long id) {
        ShowerThought thought = getShowerThoughtUseCase.execute(id);
        return ShowerThoughtMapper.INSTANCE.toDTO(thought);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ShowerThoughtDto createShowerThought(@RequestBody ShowerThoughtDto providedShowerThoughtDto) {
        ShowerThought thought = ShowerThoughtMapper.INSTANCE.fromDTO(providedShowerThoughtDto);
        thought = createShowerThoughtUseCase.execute(thought);
        return ShowerThoughtMapper.INSTANCE.toDTO(thought);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public  ShowerThoughtDto updateShowerThought(
            @PathVariable Long id, @RequestBody ShowerThoughtDto providedShowerThoughtDto) {
        ShowerThought thought = ShowerThoughtMapper.INSTANCE.fromDTO(providedShowerThoughtDto);
        thought = updateShowerThoughtUseCase.execute(id, thought);
        return ShowerThoughtMapper.INSTANCE.toDTO(thought);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ShowerThoughtDto deleteShowerThought(@PathVariable Long id) {
        ShowerThought thought = deleteShowerThoughtUseCase.execute(id);
        return ShowerThoughtMapper.INSTANCE.toDTO(thought);
    }

}
