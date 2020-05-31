package com.shasha.mskschocolateservice.repo;

import com.shasha.mskschocolateservice.domain.Chocolate;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

/**
 * Created by kobis on 31 May, 2020
 */

public interface ChocolateRepository extends PagingAndSortingRepository<Chocolate, UUID> {
}
