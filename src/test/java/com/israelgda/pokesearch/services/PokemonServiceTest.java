package com.israelgda.pokesearch.services;

import com.israelgda.pokesearch.entities.PokemonList;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class PokemonServiceTest {

    @InjectMocks
    private PokemonService pokemonService;

    @Test
    public void findBySubstringShouldReturnOrderedList(){
        PokemonList pokemonList = pokemonService.findBySubstring("saur");

        assertNotNull(pokemonList.getResults());
        assertEquals(pokemonList.getResults().get(0).getName(), "ivysaur");
        assertEquals(pokemonList.getResults().get(0).getStart(), 3);
        assertEquals(pokemonList.getResults().get(0).getEnd(), 7);
        assertEquals(pokemonList.getResults().get(1).getName(), "venusaur");
        assertEquals(pokemonList.getResults().get(1).getStart(), 4);
        assertEquals(pokemonList.getResults().get(1).getEnd(), 8);
        assertEquals(pokemonList.getResults().get(2).getName(), "bulbasaur");
        assertEquals(pokemonList.getResults().get(2).getStart(), 5);
        assertEquals(pokemonList.getResults().get(2).getEnd(), 9);
        assertEquals(pokemonList.getResults().get(3).getName(), "venusaur-gmax");
        assertEquals(pokemonList.getResults().get(3).getStart(), 4);
        assertEquals(pokemonList.getResults().get(3).getEnd(), 8);
        assertEquals(pokemonList.getResults().get(4).getName(), "venusaur-mega");
        assertEquals(pokemonList.getResults().get(4).getStart(), 4);
        assertEquals(pokemonList.getResults().get(4).getEnd(), 8);
    }
}
