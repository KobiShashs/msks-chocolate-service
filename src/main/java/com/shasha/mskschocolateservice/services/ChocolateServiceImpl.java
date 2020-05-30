package com.shasha.mskschocolateservice.services;

import com.shasha.mskschocolateservice.web.model.ChocolateDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by kobis on 30 May, 2020
 */
@Service
public class ChocolateServiceImpl implements ChocolateService {
    @Override
    public ChocolateDto getChocolateByID(UUID chocolateID) {
        return null;
    }

    @Override
    public ChocolateDto saveNewChocolate(ChocolateDto chocolateDto) {
        return null;
    }

    @Override
    public void updateChocolate(UUID chocolateID, ChocolateDto chocolateDto) {

    }

    @Override
    public void deleteById(UUID chocolateID) {

    }
}
