package com.israelgda.pokesearch.utils;

import com.israelgda.pokesearch.entities.PokemonList;

import java.util.Collections;

public class SortingUtil {

    public static PokemonList sorting(PokemonList pokemonList){

        //Sorting by name lenght - Step one

        //Using insertion sort algoritm to compare right name length and left name lenght
        for (int index = 1;index < pokemonList.getResults().size();index++){
            int position = index;

            //While position greater then zero and teh left name has a greater langth, the loop repeats
            while (position > 0 && pokemonList.getResults().get(position).getName().length() < pokemonList.getResults().get(position-1).getName().length()){
                //Swapping positions on the List if the left name has a lower lenght tha the right name
                Collections.swap(pokemonList.getResults(), position, position-1);
                //Decrementing the position to move the comparison index
                position -= 1;
            }
        }

        //Sorting by alphabetic - Step Two

        //Using insertion sort algoritm to compare right name length and left name lenght alphabetcally
        for (int index = 1;index < pokemonList.getResults().size();index++){
            int position = index;

            //The loop iterates and compares only names that are the same length and compares alphabetically since the first sort must be by length.
            while (position > 0 && pokemonList.getResults().get(position).getName().length() == pokemonList.getResults().get(position-1).getName().length()){
                //Comparing Strings if right name is alphabetically first then left name
                if(pokemonList.getResults().get(position).getName().compareTo(pokemonList.getResults().get(position-1).getName()) < 0){
                    //Swapping positions of right name and left name
                    Collections.swap(pokemonList.getResults(), position, position-1);
                }
                //Decrementing the position to move the comparison index
                position -= 1;
            }
        }
        return pokemonList;
    }
}
