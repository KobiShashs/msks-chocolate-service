package com.shasha.mskschocolateservice.web.mappers;

import com.shasha.mskschocolateservice.domain.Chocolate;
import com.shasha.mskschocolateservice.web.model.ChocolateDto;
import org.mapstruct.Mapper;

/**
 * Created by kobis on 31 May, 2020
 */
@Mapper(uses = DateMapper.class)
public interface ChocolateMapper {

    ChocolateDto chocolateToChocolateDto(Chocolate chocolate);

    Chocolate chocolateDtoTohChocolate(ChocolateDto dto);
}
