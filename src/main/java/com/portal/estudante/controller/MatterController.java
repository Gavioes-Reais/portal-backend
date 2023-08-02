package com.portal.estudante.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.estudante.dto.MatterDto;
import com.portal.estudante.service.MatterService;

@RestController
@RequestMapping(value = "/matter")
public class MatterController {

    @Autowired
    MatterService matterService;

    @PostMapping("/create")
    public ResponseEntity<MatterDto> create(@RequestBody MatterDto matterDto){
        MatterDto createdMatterDto = matterService.create(matterDto);
        
        if (createdMatterDto != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdMatterDto);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
