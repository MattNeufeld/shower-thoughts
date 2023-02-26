package com.github.mattneufeld.showerthoughts.mapper;

import com.github.mattneufeld.showerthoughts.model.ShowerThought;
import com.github.mattneufeld.showerthoughts.model.ShowerThoughtDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ShowerThoughtMapper {
    ShowerThoughtMapper INSTANCE = Mappers.getMapper(ShowerThoughtMapper.class);

    ShowerThoughtDto toDTO(ShowerThought showerThought);

    ShowerThought fromDTO(ShowerThoughtDto showerThoughtDto);

}
