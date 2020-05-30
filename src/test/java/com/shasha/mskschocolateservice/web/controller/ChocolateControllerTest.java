package com.shasha.mskschocolateservice.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shasha.mskschocolateservice.services.ChocolateService;
import com.shasha.mskschocolateservice.web.model.ChocolateDto;
import com.shasha.mskschocolateservice.web.model.ChocolateType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by kobis on 30 May, 2020
 */
@WebMvcTest(ChocolateController.class)
class ChocolateControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    ChocolateService chocolateService;

    private ChocolateDto validDto;

    @BeforeAll
    public void setUp() throws Exception {
        validDto = ChocolateDto.builder()
                .id(UUID.randomUUID())
                .chocolateName("Pikkolo")
                .chocolateType(ChocolateType.MILK)
                .upc(123456789L)
                .build();
    }

    @Test
    void getItem() throws Exception {

        given(chocolateService.getChocolateByID(any(UUID.class))).willReturn(validDto);

        mockMvc.perform(get("/api/v1/chocolate/" + validDto.getId().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(validDto.getId().toString())))
                .andExpect(jsonPath("$.chocolateName", is(validDto.getChocolateName())))
                .andExpect(jsonPath("$.chocolateType", is(validDto.getChocolateType())))
                .andExpect(jsonPath("$.upc", is(validDto.getUpc().intValue())));
    }

    @Test
    void addItem() throws Exception {

        String chocolateDtoJson = objectMapper.writeValueAsString(validDto);

        given(chocolateService.saveNewChocolate(any())).willReturn(validDto);

        mockMvc.perform(post("/api/v1/chocolate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(chocolateDtoJson))
                .andExpect(status().isCreated());
    }

    @Test
    void updateItem() throws Exception {

        String chocolateDtoJson = objectMapper.writeValueAsString(validDto);

        mockMvc.perform(put("/api/v1/chocolate/" + validDto.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(chocolateDtoJson))
                .andExpect(status().isNoContent());
    }

    @Test
    void deleteItem() throws Exception {

        String chocolateDtoJson = objectMapper.writeValueAsString(validDto);

        mockMvc.perform(delete("/api/v1/chocolate/" + validDto.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content((byte[]) null))
                .andExpect(status().isNoContent());
    }
}