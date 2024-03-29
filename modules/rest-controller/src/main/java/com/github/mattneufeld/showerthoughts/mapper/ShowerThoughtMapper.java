package com.github.mattneufeld.showerthoughts.mapper;

import com.github.mattneufeld.showerthoughts.model.ShowerThought;
import com.github.mattneufeld.showerthoughts.model.ShowerThoughtDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ShowerThoughtMapper {
    ShowerThoughtMapper INSTANCE = Mappers.getMapper(ShowerThoughtMapper.class);

    /**
     * This method allows for conversions from a core ShowerThought object to the outward facing ShowerThoughtDto.
     * @param showerThought This is the ShowerThought to be translated.
     * @return The created ShowerThoughtDto object.
     */
    ShowerThoughtDto toDTO(ShowerThought showerThought);

    /**
     * This method allows for conversions from an outward facing ShowerThoughtDto to a core ShowerThought object.
     * @param showerThoughtDto This is the ShowerThoughtDto object to be translated.
     * @return The created ShowerThought object.
     */
    @Mapping(target = "id", ignore = true)
    ShowerThought fromDTO(ShowerThoughtDto showerThoughtDto);

    /**
     * This method allows for conversions from a list of core shower thought objects to a list of outward
     * facing shower thought objects.
     * @param showerThoughts The list of core shower thought objects to be translated.
     * @return The list of created ShowerThoughtDto objects.
     */
    List<ShowerThoughtDto> toDTOList(List<ShowerThought> showerThoughts);

}
