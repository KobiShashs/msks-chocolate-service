package com.shasha.mskschocolateservice.web.controller;

import com.shasha.mskschocolateservice.services.ChocolateService;
import com.shasha.mskschocolateservice.web.model.ChocolateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

/**
 * Created by kobis on May, 2020
 */

@RequiredArgsConstructor
@RequestMapping("/api/v1/chocolate")
@RestController

public class ChocolateController {


    private final ChocolateService chocolateService;


    @GetMapping({"/{chocolateID}"})
    public ResponseEntity<ChocolateDto> getItem(@PathVariable("chocolateID") UUID chocolateID) {
        return new ResponseEntity<>(chocolateService.getChocolateByID(chocolateID), HttpStatus.OK);
    }

    @GetMapping(value = {"xml/{chocolateID}"}, produces = {"application/xml"})
    public ResponseEntity<ChocolateDto> getItem2(@PathVariable("chocolateID") UUID chocolateID) {
        return new ResponseEntity<>(chocolateService.getChocolateByID(chocolateID), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity addItem(@Valid @RequestBody ChocolateDto chocolateDto) {
        return new ResponseEntity<>(chocolateService.saveNewChocolate(chocolateDto), HttpStatus.CREATED);
    }

    @PutMapping({"/{chocolateID}"})
    public ResponseEntity updateItem(@PathVariable("chocolateID") UUID chocolateID, @Valid @RequestBody ChocolateDto chocolateDto) {

        return new ResponseEntity<>(chocolateService.updateChocolate(chocolateID, chocolateDto), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{chocolateID}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteItem(@PathVariable("chocolateID") UUID chocolateID) {
        chocolateService.deleteById(chocolateID);
    }


}
