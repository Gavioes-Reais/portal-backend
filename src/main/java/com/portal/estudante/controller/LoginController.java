package com.portal.estudante.controller;

import com.portal.estudante.dto.LoginDto;
import com.portal.estudante.entity.Person;
import com.portal.estudante.service.LoginService;
import com.portal.estudante.service.StudentService;
import com.portal.estudante.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    LoginService loginService;
    @Autowired
    TokenService tokenService;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    StudentService studentService;

    @PostMapping()
    public ResponseEntity login(@RequestBody LoginDto loginDto){

        try{
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                    new UsernamePasswordAuthenticationToken(loginDto.CPF(),
                            loginDto.password());

            Authentication authenticate = this.authenticationManager
                    .authenticate(usernamePasswordAuthenticationToken);

            var person = (Person) authenticate.getPrincipal();

            if(person != null){
                return ResponseEntity
                        .ok(tokenService.generateToken(person));
            }

        } catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Credenciais incorretas");
        }

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .build();
    }

}
