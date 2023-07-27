package com.portal.estudante.repository;

import com.portal.estudante.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findByCPFAndPassword(String cpf, String password);
    Optional<Person> findByEmail (String email);
    Optional<Person> findByCPF (String cpf);
}