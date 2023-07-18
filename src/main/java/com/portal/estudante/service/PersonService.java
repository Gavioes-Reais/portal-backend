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

    public PersonDto register(PersonDto personDto) throws Exception {
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
        if(personDto.cep() == null){
            throw new Exception("Cep não inserido");
        }
        if(personDto.city() == null){
            throw new Exception("Cidade não inserido");
        }
        if(personDto.uf() == null){
            throw new Exception("Estado não inserido");
        }
        if(personDto.street() == null){
            throw new Exception("Logradouro não inserido");
        }
        if(personDto.district() == null){
            throw new Exception("Bairro não inserido");
        }
        if(personDto.number() == null){
            throw new Exception("Número não inserido");
        }
        if(personDto.complement() == null){
            throw new Exception("Complemento não inserido");
        }
        personRepository.save(personDto.toEntity());
        return personDto;
    }


}
