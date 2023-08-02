package com.portal.estudante.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portal.estudante.entity.Matter;

@Repository
public interface MatterRepository extends JpaRepository<Matter, Long> {
    
}
