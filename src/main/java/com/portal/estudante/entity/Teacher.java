package com.portal.estudante.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity(name = "teacher")
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        public Long id;

        @Column(name = "teacher_identifier", nullable = false)
        public String teacherIdentifier;

        @OneToOne
        public Person person;
    }
