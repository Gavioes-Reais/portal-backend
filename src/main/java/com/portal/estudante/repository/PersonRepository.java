package com.portal.estudante.repository;

import com.portal.estudante.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findByCPFAndPassword(String cpf, String password);
}
