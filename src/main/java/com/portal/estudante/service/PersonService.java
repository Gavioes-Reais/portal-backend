package com.portal.estudante.service;

import com.portal.estudante.dto.PersonDto;
import com.portal.estudante.entity.Person;
import com.portal.estudante.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public PersonDto create(PersonDto personDto) throws Exception {
        Person entity = personDto.toEntity();

        if(personDto.name() == null){
            throw new Exception("Nome não inserido");
        }
        
        if(personDto.password() == null){
            throw new Exception("Senha não inserida");
        }
        if(personDto.email() == null){
            throw new Exception("Email invalido");
        }
        if(personDto.CPF() == null){
            throw new Exception("CPF não inserido");
        }
        if(personDto.birthDate() == null){
            throw new Exception("Data de nascimento não inserido");
        }
        return personDto;
    }


}
