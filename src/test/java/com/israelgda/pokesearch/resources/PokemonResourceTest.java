package com.israelgda.pokesearch.resources;

import com.israelgda.pokesearch.entities.PokemonList;
import com.israelgda.pokesearch.services.PokemonService;
import com.israelgda.pokesearch.utils.ListBuilderUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PokemonResource.class)
public class PokemonResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PokemonService pokemonService;

    @Test
    public void findBySubstringShouldReturnOrderedList() throws Exception {
        PokemonList list = new PokemonList(ListBuilderUtil.buildSaurList());
        when(pokemonService.findBySubstring("saur")).thenReturn(list);

        ResultActions result = mockMvc.perform(get("/v1/pokemons?query={substring}", "saur")
                                    .accept(MediaType.APPLICATION_JSON));

        result.andExpect(status().isOk());
        result.andExpect(jsonPath("$.results[0].name").value("ivysaur"));
        result.andExpect(jsonPath("$.results[0].start").value(3));
        result.andExpect(jsonPath("$.results[0].end").value(7));
        result.andExpect(jsonPath("$.results[1].name").value("venusaur"));
        result.andExpect(jsonPath("$.results[1].start").value(4));
        result.andExpect(jsonPath("$.results[1].end").value(8));
        result.andExpect(jsonPath("$.results[2].name").value("bulbasaur"));
        result.andExpect(jsonPath("$.results[2].start").value(5));
        result.andExpect(jsonPath("$.results[2].end").value(9));
        result.andExpect(jsonPath("$.results[3].name").value("venusaur-gmax"));
        result.andExpect(jsonPath("$.results[3].start").value(4));
        result.andExpect(jsonPath("$.results[3].end").value(8));
        result.andExpect(jsonPath("$.results[4].name").value("venusaur-mega"));
        result.andExpect(jsonPath("$.results[4].start").value(4));
        result.andExpect(jsonPath("$.results[4].end").value(8));
    }
}
