package com.portal.estudante.repository;

import com.portal.estudante.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CityRepository extends JpaRepository<City, Long> {

    Optional<City> findByName (String name);
}
