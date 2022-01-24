package com.israelgda.pokesearch.services.client;

import com.israelgda.pokesearch.entities.Pokemon;
import com.israelgda.pokesearch.entities.PokemonList;
import com.israelgda.pokesearch.utils.SortingUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

public class PokeAPIClient {

    private static RestTemplate templatePokeApi = new RestTemplate();

    private static UriComponents uri;

    public static PokemonList searchPokemons(String substring){

        uri = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("pokeapi.co")
                .path("api/v2/pokemon?limit=1118")
                .build();

        ResponseEntity<PokemonList> response = templatePokeApi.getForEntity(uri.toUriString(), PokemonList.class);

        PokemonList resultList = new PokemonList();

        List<Pokemon> pokemonsList = response.getBody().getResults();

        filter(pokemonsList, resultList, substring);

        SortingUtil.sorting(resultList);

        return resultList;
    }

    private static void filter(List<Pokemon> pokemonsList, PokemonList resultList, String substring){
        pokemonsList.stream().forEach(item -> {
            if(item.getName().contains(substring))
                resultList.addPokemon(item.getName(), item.getName().indexOf(substring), item.getName().indexOf(substring)+substring.length());
        });
    }
}
