package com.portal.estudante.dto;

import com.portal.estudante.entity.Address;
import com.portal.estudante.entity.City;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.portal.estudante.entity.Person;
import com.portal.estudante.entity.State;

import java.sql.Date;
import java.util.Optional;


public record PersonDto(Long id, String name, String CPF, String password, @JsonFormat(pattern = "dd-MM-yyyy") Date birthDate,
                        String email, String cep, String city, String uf, String street, String district,
                        String number, String complement) {

    public Person toEntity(){
        Person entity = new Person();
        entity.setId(this.id());
        entity.setName(this.name());
        entity.setPassword(this.password());
        entity.setEmail(this.email());
        entity.setCPF(this.CPF());
        entity.setBirthDate(this.birthDate());

        Address address = new Address();
        address.setCep(this.cep);
        address.setStreet(this.street);
        address.setDistrict(this.district);
        address.setNumber(this.number);
        address.setComplement(this.complement);

        City city = new City();
        city.setName(this.city);

        State state = new State();
        state.setShortName(this.uf);

        city.setState(state);
        address.setCity(city);
        entity.setAddress(address);

        return entity;
    }

}
