package com.mx.globant.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/globant-api")
public class GlobantController {

    @GetMapping("")
    public void getAllCharacters() {

    }

    @GetMapping("/")
    public void getAllCharactersByID() {

    }

    @GetMapping("/{id-character}/")
    public void getHistoryRegister() {

    }

}
