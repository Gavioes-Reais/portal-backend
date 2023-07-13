package com.portal.estudante.controller;

import com.portal.estudante.dto.LoginDto;
import com.portal.estudante.service.LoginService;
import com.portal.estudante.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    LoginService loginService;
    @Autowired
    StudentService studentService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto){
        String authorized = loginService.verifyLogin(loginDto);
        return ResponseEntity.ok(authorized);
    }

}
