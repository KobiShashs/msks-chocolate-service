package com.shasha.mskschocolateservice.services;

import com.shasha.mskschocolateservice.web.model.ChocolateDto;

import java.util.UUID;

/**
 * Created by kobis on 30 May, 2020
 */
public interface ChocolateService {
    ChocolateDto getChocolateByID(UUID chocolateID);

    ChocolateDto saveNewChocolate(ChocolateDto chocolateDto);

    ChocolateDto updateChocolate(UUID chocolateID, ChocolateDto chocolateDto);

    void deleteById(UUID chocolateID);
}
