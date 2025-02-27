package com.israelgda.pokesearch.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Pokemon {

    private String name;
    private Integer start;
    private Integer end;

    public Pokemon(){

    }
}
