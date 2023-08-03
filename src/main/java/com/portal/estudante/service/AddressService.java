package com.portal.estudante.service;

import com.portal.estudante.dto.PersonDto;
import com.portal.estudante.entity.Address;
import com.portal.estudante.entity.City;
import com.portal.estudante.repository.AddressRepository;
import com.portal.estudante.repository.CityRepository;
import com.portal.estudante.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    CityRepository cityRepository;

    @Autowired
    StateRepository stateRepository;

    public Address createAddress(PersonDto personDto) throws Exception {
        Address address = new Address();
        address.setCep(personDto.cep());
        address.setStreet(personDto.street());
        address.setDistrict(personDto.district());
        address.setNumber(personDto.number());
        address.setComplement(personDto.complement());

        address.setCity(findCity(personDto.cityName()));

        return addressRepository.save(address);
    }

    private City findCity(String name) throws Exception {
        Optional<City> city = cityRepository.findByName(name);
        if(city.isEmpty())
            throw new Exception("Cidade nao encontrada");

        return city.get();
    }
}
