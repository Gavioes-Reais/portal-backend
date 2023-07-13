package com.portal.estudante.service;

import com.portal.estudante.dto.LoginDto;
import com.portal.estudante.entity.Person;
import com.portal.estudante.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class LoginService {
    @Autowired
    PersonRepository personRepository;
    public String verifyLogin(LoginDto loginDto) {
        try {
            Optional<Person> person = personRepository.findByCPFAndPassword(loginDto.CPF(), loginDto.password());
            if(person.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado");
            }
            return "Aqui será retornado um Token";
        } catch (ResponseStatusException exception){
            throw new ResponseStatusException(exception.getStatusCode(), exception.getReason());
        }
    }
}
