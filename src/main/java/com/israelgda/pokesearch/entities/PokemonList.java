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

    public void addPokemon(String name, int startIndex, int endIndex){
        results.add(new Pokemon(name, startIndex, endIndex));
    }
}
