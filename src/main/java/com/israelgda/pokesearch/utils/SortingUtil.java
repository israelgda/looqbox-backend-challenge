package com.israelgda.pokesearch.utils;

import com.israelgda.pokesearch.entities.PokemonList;

import java.util.Collections;

public class SortingUtil {

    public static PokemonList sorting(PokemonList pokemonList){

        //Sorting by name lenght - Step one
        for (int index = 1;index < pokemonList.getResults().size();index++){
            int position = index;


            while (position > 0 && pokemonList.getResults().get(position).getName().length() < pokemonList.getResults().get(position-1).getName().length()){
                Collections.swap(pokemonList.getResults(), position, position-1);
                position -= 1;
            }
        }

        //Sorting by alphabetic - Step Two
        for (int index = 1;index < pokemonList.getResults().size();index++){
            int position = index;

            while (position > 0 && pokemonList.getResults().get(position).getName().length() == pokemonList.getResults().get(position-1).getName().length()){
                if(pokemonList.getResults().get(position).getName().compareTo(pokemonList.getResults().get(position-1).getName()) < 0){
                    Collections.swap(pokemonList.getResults(), position, position-1);
                }
                position -= 1;
            }
        }
        return pokemonList;
    }
}
