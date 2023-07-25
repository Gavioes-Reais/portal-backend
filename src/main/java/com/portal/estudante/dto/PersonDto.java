package com.portal.estudante.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.portal.estudante.entity.Person;
import com.portal.estudante.utils.Role;
import java.sql.Date;

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
        entity.setCep(this.cep);
        entity.setCity(this.city);
        entity.setUf(this.uf);
        entity.setStreet(this.street);
        entity.setDistrict(this.district);
        entity.setNumber(this.number);
        entity.setComplement(this.complement);
        return entity;
    }
}
