package com.israelgda.pokesearch.resources;

import com.israelgda.pokesearch.entities.PokemonList;
import com.israelgda.pokesearch.services.PokemonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/pokemons")
public class PokemonResource {

    private final PokemonService pokemonService;

    public PokemonResource(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping
    public ResponseEntity<PokemonList> findBySubstring(@RequestParam(value = "query", defaultValue = "") String substring){
        PokemonList pokemonList = pokemonService.findBySubstring(substring);
        return ResponseEntity.ok().body(pokemonList);
    }
}
