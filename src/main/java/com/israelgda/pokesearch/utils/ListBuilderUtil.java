package com.israelgda.pokesearch.utils;

import com.israelgda.pokesearch.entities.Pokemon;

import java.util.Arrays;
import java.util.List;

public class ListBuilderUtil {

    public static List<Pokemon> buildSaurList(){
        List<Pokemon> list = Arrays.asList(
                new Pokemon("ivysaur", 3, 7),
                new Pokemon("venusaur", 4, 8),
                new Pokemon("bulbasaur", 5, 9),
                new Pokemon("venusaur-gmax", 4, 8),
                new Pokemon("venusaur-mega", 4, 8));

        return list;
    }
}
