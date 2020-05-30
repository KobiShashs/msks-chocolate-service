package com.shasha.mskschocolateservice.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * Created by kobis on 30 May, 2020
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChocolateDto {

    private UUID id;
    private Integer version;
    private OffsetDateTime createdDate;
    private OffsetDateTime lastModifiedDate;
    private String chocolateName;
    private ChocolateType chocolateType;
    private Long upc;
    private BigDecimal price;
    private Integer quantityOnHand;
}
