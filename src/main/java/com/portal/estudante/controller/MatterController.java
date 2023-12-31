package com.portal.estudante.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/{id}")
    public ResponseEntity<MatterDto> getById(@PathVariable Long id){
        try{
            MatterDto matter = matterService.getById(id);
            return ResponseEntity.status(HttpStatus.OK).body(matter);
        } catch( Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }   
    }

    @GetMapping("/")
    public ResponseEntity<List<MatterDto>> get(){
        try{
            List<MatterDto> matterList = matterService.getAllMatters();
            return ResponseEntity.status(HttpStatus.OK).body(matterList);
        } catch( Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }   
    }

    @PutMapping("/update")
    public ResponseEntity<MatterDto> update(@RequestBody MatterDto matterDto){
        try{
            MatterDto matter = matterService.updateMatter(matterDto);
            return ResponseEntity.status(HttpStatus.OK).body(matter);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try{
            matterService.deleteMatter(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}