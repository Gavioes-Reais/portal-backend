package com.portal.estudante.controller;

import com.portal.estudante.dto.PersonDto;
import com.portal.estudante.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/register")
public class CadastroController {

    @Autowired
    PersonService personService;

    @PostMapping
    public ResponseEntity register(@RequestBody PersonDto personDto) {
        try {
            return new ResponseEntity<>(personService.register(personDto), HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
}
