package com.github.mattneufeld.showerthoughts.controller;

import com.github.mattneufeld.showerthoughts.model.ShowerThought;
import com.github.mattneufeld.showerthoughts.usecase.*;
import com.github.mattneufeld.showerthoughts.mapper.ShowerThoughtMapper;
import com.github.mattneufeld.showerthoughts.model.ShowerThoughtDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/showerthought")
@CrossOrigin
public class ShowerThoughtController {

    private final ReadShowerThoughtUseCase readShowerThoughtUseCase;
    private final CreateShowerThoughtUseCase createShowerThoughtUseCase;
    private final UpdateShowerThoughtUseCase updateShowerThoughtUseCase;
    private final DeleteShowerThoughtUseCase deleteShowerThoughtUseCase;

    private final ReadAllShowerThoughtUseCase readAllShowerThoughtUseCase;

    /**
     * This is the constructor for the shower thought rest controller.
     * @param readShowerThoughtUseCase This is the use case for reading a shower thought from the database.
     * @param createShowerThoughtUseCase This is the use case for adding a shower thought to the database.
     * @param deleteShowerThoughtUseCase This is the use case for deleting a shower thought from the database.
     * @param updateShowerThoughtUseCase This is the use case for updating a shower thought within the database.
     * @param readAllShowerThoughtUseCase This is the use case for reading all the shower thoughts from the database.
     */
    @Autowired
    public ShowerThoughtController(
            ReadShowerThoughtUseCase readShowerThoughtUseCase,
            CreateShowerThoughtUseCase createShowerThoughtUseCase,
            DeleteShowerThoughtUseCase deleteShowerThoughtUseCase,
            UpdateShowerThoughtUseCase updateShowerThoughtUseCase,
            ReadAllShowerThoughtUseCase readAllShowerThoughtUseCase) {
        this.readShowerThoughtUseCase = readShowerThoughtUseCase;
        this.createShowerThoughtUseCase = createShowerThoughtUseCase;
        this.updateShowerThoughtUseCase = updateShowerThoughtUseCase;
        this.deleteShowerThoughtUseCase = deleteShowerThoughtUseCase;
        this.readAllShowerThoughtUseCase = readAllShowerThoughtUseCase;
    }

    /**
     * This method reads the requested shower thought from the database and returns it to the user.
     * @param id This is the ID of the requested shower thought.
     * @return This is the requested shower thought.
     */
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ShowerThoughtDto readShowerThought(@PathVariable Long id) {
        ShowerThought thought = readShowerThoughtUseCase.execute(id);
        return ShowerThoughtMapper.INSTANCE.toDTO(thought);
    }

    /**
     * This method adds a new user provided shower thought to the database.
     * @param providedShowerThoughtDto The shower thought provided by the user.
     * @return The shower thought added to the database with correct database ID.
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ShowerThoughtDto createShowerThought(@RequestBody ShowerThoughtDto providedShowerThoughtDto) {
        ShowerThought thought = ShowerThoughtMapper.INSTANCE.fromDTO(providedShowerThoughtDto);
        thought = createShowerThoughtUseCase.execute(thought);
        return ShowerThoughtMapper.INSTANCE.toDTO(thought);
    }

    /**
     * This method updates a shower thought that already exists within the database.
     * @param id This is the id of the shower thought to be replaced.
     * @param providedShowerThoughtDto This is the shower thought for the databased to be updated with.
     * @return ShowerThoughtDto This is the object that was updated within the database.
     */
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public  ShowerThoughtDto updateShowerThought(
            @PathVariable Long id, @RequestBody ShowerThoughtDto providedShowerThoughtDto) {
        ShowerThought thought = ShowerThoughtMapper.INSTANCE.fromDTO(providedShowerThoughtDto);
        thought = updateShowerThoughtUseCase.execute(id, thought);
        return ShowerThoughtMapper.INSTANCE.toDTO(thought);
    }

    /**
     * This method deletes a specific shower thought from the database based on ID.
     * @param id This is the ID of the shower thought the user wants to delete.
     * @return ShowerThoughtDto This is the user facing shower thought object that was deleted.
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ShowerThoughtDto deleteShowerThought(@PathVariable Long id) {
        ShowerThought thought = deleteShowerThoughtUseCase.execute(id);
        return ShowerThoughtMapper.INSTANCE.toDTO(thought);
    }

    /**
     * This method reads all the shower thoughts currently in the database.
     * @return A list of all the shower thoughts in the database
     */
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<ShowerThoughtDto> readAllShowerThought() {
        List<ShowerThought> thoughts = readAllShowerThoughtUseCase.execute();
        return ShowerThoughtMapper.INSTANCE.toDTOList(thoughts);
    }

}
