package com.portal.estudante.dto;

import com.portal.estudante.entity.Person;
import com.portal.estudante.utils.Role;
import java.sql.Date;

public record PersonDto(Long id, String name, String CPF, String password, Date birthDate, Role role, String email) {

    public Person toEntity(){
        Person entity = new Person();
        entity.setId(this.id());
        entity.setName(this.name());
        entity.setPassword(this.password());
        entity.setEmail(this.email());
        entity.setCPF(this.CPF());
        entity.setBirthDate(this.birthDate());
        entity.setRole(this.role());
        return entity;
    }
}
