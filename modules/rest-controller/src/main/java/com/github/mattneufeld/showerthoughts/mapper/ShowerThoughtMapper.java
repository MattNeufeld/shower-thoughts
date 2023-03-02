package com.github.mattneufeld.showerthoughts.mapper;

import com.github.mattneufeld.showerthoughts.model.ShowerThought;
import com.github.mattneufeld.showerthoughts.model.ShowerThoughtDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

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

}
