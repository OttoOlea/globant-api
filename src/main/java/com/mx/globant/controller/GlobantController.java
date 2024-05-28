package com.mx.globant.controller;

import com.mx.globant.service.GlobantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequestMapping("/v1/globant-api")
public class GlobantController {

    @Autowired
    private GlobantService globantService;


    @GetMapping("/status")
    public ResponseEntity upService() {
        return ResponseEntity.ok("Time: " + Instant.now());
    }

    @GetMapping("/characters")
    public ResponseEntity getAllCharacters() {
        return globantService.getAllCharacters();
    }

    @GetMapping("/characters/{characterId}")
    public ResponseEntity getCharactersByID(@PathVariable(name = "characterId") Integer characterId) {

        if (characterId == null) {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body("The value for ID is incorrect");

        } else {
            return new ResponseEntity<>(globantService.getCharacterByID(characterId), HttpStatus.OK);
        }
    }

    @GetMapping("/history")
    public ResponseEntity getHistoryRegister() {
        //return ResponseEntity <>(globantService.getHistoryDB(), HttpStatus.OK);
        return null;
    }

}
