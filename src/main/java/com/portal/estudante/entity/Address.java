package com.portal.estudante.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false)
     public String cep;

    @Column(nullable = false)
    public String street;

    @Column(nullable = false)
    public String district;

    @Column(nullable = false)
    public String number;

    @Column(nullable = false)
    public String complement;

    @ManyToOne
    public City city ;

}
