package com.shasha.mskschocolateservice.bootstrap;

import com.shasha.mskschocolateservice.domain.Chocolate;
import com.shasha.mskschocolateservice.repo.ChocolateRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Created by kobis on 31 May, 2020
 */
@Component
public class ChocolateLoader implements CommandLineRunner {

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
                    .quantityToCreate(200)
                    .minOnHand(12)
                    .price(new BigDecimal("12.95"))
                    .build());

            chocolateRepository.save(Chocolate.builder()
                    .chocolateName("Bounty")
                    .chocolateSlogan("coconut palms like")
                    .quantityToCreate(200)
                    .minOnHand(12)
                    .price(new BigDecimal("11.95"))
                    .build());
        }

        System.out.println("Loaded = " + chocolateRepository.count());
    }
}
