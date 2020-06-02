package com.shasha.mskschocolateservice.services;

import com.shasha.mskschocolateservice.domain.Chocolate;
import com.shasha.mskschocolateservice.repo.ChocolateRepository;
import com.shasha.mskschocolateservice.web.controller.NotFoundException;
import com.shasha.mskschocolateservice.web.mappers.ChocolateMapper;
import com.shasha.mskschocolateservice.web.model.ChocolateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by kobis on 30 May, 2020
 */
@RequiredArgsConstructor
@Service
public class ChocolateServiceImpl implements ChocolateService {

    private final ChocolateRepository chocolateRepository;
    private final ChocolateMapper chocolateMapper;

    @Override
    public ChocolateDto getChocolateByID(UUID chocolateID) {
        return chocolateMapper.chocolateToChocolateDto(chocolateRepository.findById(chocolateID).orElseThrow(NotFoundException::new));
    }

    @Override
    public ChocolateDto saveNewChocolate(ChocolateDto chocolateDto) {
        return chocolateMapper.chocolateToChocolateDto(chocolateRepository.save(chocolateMapper.chocolateDtoToChocolate(chocolateDto)));
    }

    @Override
    public ChocolateDto updateChocolate(UUID chocolateID, ChocolateDto chocolateDto) {
        Chocolate chocolate = chocolateRepository.findById(chocolateID).orElseThrow(NotFoundException::new);

        chocolate.setChocolateName(chocolateDto.getChocolateName());
        chocolate.setChocolateSlogan(chocolateDto.getChocolateType().name());
        chocolate.setPrice(chocolateDto.getPrice());
        chocolate.setUpc(chocolateDto.getUpc());

        return chocolateMapper.chocolateToChocolateDto(chocolate);
    }

    @Override
    public void deleteById(UUID chocolateID) {
        Chocolate chocolate = chocolateRepository.findById(chocolateID).orElseThrow(NotFoundException::new);
        chocolateRepository.deleteById(chocolateID);
    }
}
