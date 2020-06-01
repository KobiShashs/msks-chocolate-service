package com.shasha.mskschocolateservice.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shasha.mskschocolateservice.bootstrap.ChocolateLoader;
import com.shasha.mskschocolateservice.services.ChocolateService;
import com.shasha.mskschocolateservice.web.model.ChocolateDto;
import com.shasha.mskschocolateservice.web.model.ChocolateType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by kobis on 30 May, 2020
 */
@WebMvcTest(ChocolateController.class)
class ChocolateControllerTest {

    @Autowired
    MockMvc mockMvc;


    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    ChocolateService chocolateService;

    // private ChocolateDto validDto;

//    @BeforeEach
//    public void setUp() throws Exception {
//        validDto = ChocolateDto.builder()
//                .id(UUID.randomUUID())
//                .chocolateName("Pikkolo")
//                .chocolateType(ChocolateType.MILK)
//                .upc(123456789L)
//                .build();
//    }

    ChocolateDto getValidDto() {
        return ChocolateDto.builder()
                .id(UUID.randomUUID())
                .chocolateName("Bounty")
                .chocolateSlogan("coconut palms like")
                .chocolateType(ChocolateType.MILK)
                .price(new BigDecimal("11.95"))
                .upc(ChocolateLoader.CHOCOLATE_2_UPC)
                .build();
    }

    @Test
    void getItemById() throws Exception {

        given(chocolateService.getChocolateByID(any(UUID.class))).willReturn(getValidDto());

        ChocolateDto chocolateDto = getValidDto();
        mockMvc.perform(get("/api/v1/chocolate/" + UUID.randomUUID()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.id", is(getValidDto().getId().toString())))
//                .andExpect(jsonPath("$.chocolateName", is(getValidDto().getChocolateName())))
//                .andExpect(jsonPath("$.chocolateType", is(getValidDto().getChocolateType())))
//                .andExpect(jsonPath("$.upc", is(getValidDto().getUpc().intValue())));
    }

    @Test
    void addItem() throws Exception {

        ChocolateDto chocolateDto = getValidDto();
        chocolateDto.setId(null);
        ChocolateDto savedDto = ChocolateDto.builder().id(UUID.randomUUID()).chocolateName("Milki").build();
        String chocolateDtoJson = objectMapper.writeValueAsString(chocolateDto);

        given(chocolateService.saveNewChocolate(any())).willReturn(savedDto);

        mockMvc.perform(post("/api/v1/chocolate/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(chocolateDtoJson))
                .andExpect(status().isCreated());
    }

    @Test
    void updateItem() throws Exception {
        ChocolateDto chocolateDto = getValidDto();
        chocolateDto.setId(null);
        String chocolateDtoJson = objectMapper.writeValueAsString(chocolateDto);

        mockMvc.perform(put("/api/v1/chocolate/" + UUID.randomUUID().toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(chocolateDtoJson))
                .andExpect(status().isNoContent());
    }

    @Test
    void deleteItem() throws Exception {

        String chocolateDtoJson = objectMapper.writeValueAsString(getValidDto());

        mockMvc.perform(delete("/api/v1/chocolate/" + getValidDto().getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content((byte[]) null))
                .andExpect(status().isNoContent());
    }
}