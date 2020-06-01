package com.shasha.mskschocolateservice.bootstrap;

import com.shasha.mskschocolateservice.domain.Chocolate;
import com.shasha.mskschocolateservice.repo.ChocolateRepository;
import com.shasha.mskschocolateservice.web.model.ChocolateType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Created by kobis on 31 May, 2020
 */
@Component
public class ChocolateLoader implements CommandLineRunner {

    public static final String CHOCOLATE_1_UPC = "0631234200036";
    public static final String CHOCOLATE_2_UPC = "0631234300019";
    public static final String CHOCOLATE_3_UPC = "0083783375213";
    private final ChocolateRepository chocolateRepository;

    public ChocolateLoader(ChocolateRepository chocolateRepository) {
        this.chocolateRepository = chocolateRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        loadChocolateObjects();

    }

    private void loadChocolateObjects() {
        if (chocolateRepository.count() == 0) {
            chocolateRepository.save(Chocolate.builder()
                    .chocolateName("Mars")
                    .chocolateSlogan("the MARS® bar is a delicious fusion of chocolate, caramel and nougat")
                    .chocolateType(ChocolateType.MILK)
                    .quantityToCreate(200)
                    .minOnHand(12)
                    .price(new BigDecimal("12.95"))
                    .upc(CHOCOLATE_1_UPC)
                    .build());

            chocolateRepository.save(Chocolate.builder()
                    .chocolateName("Bounty")
                    .chocolateSlogan("coconut palms like")
                    .chocolateType(ChocolateType.MILK)
                    .quantityToCreate(200)
                    .minOnHand(12)
                    .price(new BigDecimal("11.95"))
                    .upc(CHOCOLATE_2_UPC)
                    .build());

            chocolateRepository.save(Chocolate.builder()
                    .chocolateName("Dark Mekupelet")
                    .chocolateSlogan("Until the last crumb!!!")
                    .chocolateType(ChocolateType.DARK)
                    .quantityToCreate(200)
                    .minOnHand(12)
                    .price(new BigDecimal("11.95"))
                    .upc(CHOCOLATE_3_UPC)
                    .build());
        }

        System.out.println("Loaded = " + chocolateRepository.count());
    }
}
