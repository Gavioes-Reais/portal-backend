package com.portal.estudante.controller;

import com.portal.estudante.dto.LoginDto;
import com.portal.estudante.entity.Person;
import com.portal.estudante.service.LoginService;
import com.portal.estudante.service.StudentService;
import com.portal.estudante.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    LoginService loginService;
    @Autowired
    TokenService tokenService;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    StudentService studentService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto){
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
            new UsernamePasswordAuthenticationToken(loginDto.CPF(),
                    loginDto.password());

        Authentication authenticate = this.authenticationManager
                .authenticate(usernamePasswordAuthenticationToken);

        var person = (Person) authenticate.getPrincipal();

        String verified = loginService.verifyLogin(loginDto);

        if(!verified.isEmpty()){
            return ResponseEntity.ok(tokenService.generateToken(person));
        }
        return ResponseEntity.notFound().build();
    }

}
