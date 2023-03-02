package com.github.mattneufeld.showerthoughts.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

/**
 * This is the outward facing representation of the ShowerThought object.
 */
@Getter
@Setter
@JsonInclude
public class ShowerThoughtDto {
    private Long id;
    private String thought;

}
