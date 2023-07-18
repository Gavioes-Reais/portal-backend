package com.portal.estudante.controller;

import com.portal.estudante.dto.PersonDto;
import com.portal.estudante.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/registro")
public class CadastroController {

    @Autowired
    PersonService personService;

    @PostMapping("")
    public ResponseEntity<PersonDto> register(@RequestBody PersonDto personDto) {
        try {
            return new ResponseEntity<>(personService.register(personDto), HttpStatus.CREATED);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
