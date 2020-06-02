package com.shasha.mskschocolateservice.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * Created by kobis on 30 May, 2020
 */

@XmlRootElement
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChocolateDto {

    @Null
    private UUID id;

    @Null
    private Integer version;

    @Null
    private OffsetDateTime createdDate;

    @Null
    private OffsetDateTime lastModifiedDate;

    @NotBlank
    private String chocolateName;

    @NotBlank
    private String chocolateSlogan;

    @NotNull
    private ChocolateType chocolateType;

    //@Positive
    @NotNull
    private String upc;

    @Positive
    @NotNull
    private BigDecimal price;
    private Integer quantityOnHand;
}
