package com.portal.estudante.dto;

import com.portal.estudante.entity.Address;
import com.portal.estudante.entity.City;

public record AddressDto(String cep, String street, String district, String number, String complement, City city) {

    public Address toEntity(PersonDto person){
        Address entity = new Address();
        entity.setCep(this.cep);
        entity.setStreet(this.street);
        entity.setDistrict(this.district);
        entity.setNumber(this.number);
        entity.setComplement(this.complement);

        return entity;

    }

}
