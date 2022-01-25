package com.israelgda.pokesearch.services;

import com.israelgda.pokesearch.entities.PokemonList;
import com.israelgda.pokesearch.services.client.PokeAPIClient;
import org.springframework.stereotype.Service;

@Service
public class PokemonService {

    public PokemonList findBySubstring(String substring) {
        PokemonList pokemonList = PokeAPIClient.searchPokemons(substring);

        return pokemonList;
    }
}
