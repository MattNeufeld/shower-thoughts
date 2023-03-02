package com.github.mattneufeld.showerthoughts.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This is the core object defining what a "shower thought" is.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShowerThought {
    private Long id;
    private String thought;

}
