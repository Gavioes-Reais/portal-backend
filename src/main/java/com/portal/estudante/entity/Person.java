package com.portal.estudante.entity;

import com.portal.estudante.utils.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity(name = "person")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false)
    public String name;

    @Column(nullable = false)
    public String CPF;

    @Column(nullable = false)
    public String password;

    @Column(name = "birth_date", nullable = false)
    public Date birthDate;

    @Column
    public String email;

    @Column(nullable = false)
    public Role role;

    @Column(nullable = false)
    String cep;

    @Column(nullable = false)
    String city;

    @Column(nullable = false)
    String uf;

    @Column(nullable = false)
    String street;

    @Column(nullable = false)
    String district;

    @Column(nullable = false)
    String number;

    @Column(nullable = false)
    String complement;
}
