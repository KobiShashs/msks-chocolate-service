package com.shasha.mskschocolateservice.web.controller;

import com.shasha.mskschocolateservice.services.ChocolateService;
import com.shasha.mskschocolateservice.web.model.ChocolateDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Created by kobis on May, 2020
 */

@RequestMapping("/api/v1/chocolate")
@RestController

public class ChocolateController {

    private final ChocolateService chocolateService;

    public ChocolateController(ChocolateService chocolateService) {
        this.chocolateService = chocolateService;
    }

    @GetMapping({"/{chocolateID}"})
    public ResponseEntity<ChocolateDto> getItem(@PathVariable("chocolateID") UUID chocolateID) {
        //return new ResponseEntity<>(ChocolateDto.builder().build(), HttpStatus.OK);
        return new ResponseEntity<>(chocolateService.getChocolateByID(chocolateID), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity addItem(@RequestBody ChocolateDto chocolateDto) {
        ChocolateDto savedDto = chocolateService.saveNewChocolate(chocolateDto);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/chocolate/" + savedDto.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping({"/{chocolateID}"})
    public ResponseEntity updateItem(@PathVariable("chocolateID") UUID chocolateID, @RequestBody ChocolateDto chocolateDto) {

        chocolateService.updateChocolate(chocolateID, chocolateDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{chocolateID}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteItem(@PathVariable("chocolateID") UUID chocolateID) {
        chocolateService.deleteById(chocolateID);
    }


}
