package com.portal.estudante.service;

import com.portal.estudante.dto.AddressDto;
import com.portal.estudante.dto.PersonDto;
import com.portal.estudante.entity.Address;
import com.portal.estudante.entity.Person;
import com.portal.estudante.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    AddressService addressService;

    @Autowired
    PasswordEncoder passwordEncoder;

    public PersonDto register(PersonDto personDto) throws Exception {

        validatePerson(personDto);

        Person person = personDto.toEntity();
        person.setPassword(passwordEncoder.encode(personDto.password()));
        person.setAddress(setPersonAddress(personDto));
        personRepository.save(person);

        return personDto;
    }

    public void validatePerson(PersonDto personDto) throws Exception{

        if(personDto.name() == null)
            throw new Exception("Campo 'name' é obrigatório");

        if(personDto.password() == null)
            throw new Exception("Campo 'password' é obrigatório");

        if(personDto.email() == null)
            throw new Exception("Campo 'email' é obrigatório");

        if(personDto.CPF() == null)
            throw new Exception("Campo 'CPF' é obrigatório");

        if(personDto.birthDate() == null)
            throw new Exception("Campo 'birthdate' é obrigatório");

        if(personDto.cep() == null)
            throw new Exception("Campo 'cep' é obrigatório");

        if(personDto.cityName() == null)
            throw new Exception("Campo 'cityName' é obrigatório");

        if(personDto.ufShortName() == null)
            throw new Exception("Campo 'ufShortName' é obrigatório");

        if(personDto.street() == null)
            throw new Exception("Campo 'street' é obrigatório");

        if(personDto.district() == null)
            throw new Exception("Campo 'district' é obrigatório");

        if(personDto.number() == null)
            throw new Exception("Campo 'number' é obrigatório");

        if(personDto.complement() == null)
            throw new Exception("Campo 'complement' é obrigatório");

        if(personRepository.findByEmail(personDto.email()).isPresent())
            throw new Exception("Este email já foi cadastrado");

        if(personRepository.findByCPF(personDto.CPF()).isPresent())
            throw new Exception("Este CPF já foi cadastrado");
    }

    public Address setPersonAddress(PersonDto personDto) throws Exception{

        return(addressService.createAddress(personDto));
    }

}
