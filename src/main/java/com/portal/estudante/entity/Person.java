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

    @Column
    public String name;

    @Column
    public String CPF;

    @Column
    public String password;

    @Column(name = "birth_date")
    public Date birthDate;

    @Column
    public Role role;
}
