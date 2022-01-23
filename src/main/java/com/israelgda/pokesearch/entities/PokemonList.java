package com.israelgda.pokesearch.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class PokemonList {

    private List<Pokemon> results = new ArrayList<>();

    public PokemonList(){

    }
}
