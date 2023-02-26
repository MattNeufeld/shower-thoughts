package com.github.mattneufeld.showerthoughts.rest.mapper;

import com.github.mattneufeld.showerthoughts.core.model.ShowerThought;
import com.github.mattneufeld.showerthoughts.rest.model.ShowerThoughtDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Map;

@Mapper
public interface ShowerThoughtMapper {
    ShowerThoughtMapper INSTANCE = Mappers.getMapper(ShowerThoughtMapper.class);

    ShowerThoughtDto toDTO(ShowerThought thought);



}
