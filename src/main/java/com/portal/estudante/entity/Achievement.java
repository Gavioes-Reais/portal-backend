package com.portal.estudante.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity(name = "achievement")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Achievement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @Column(name = "birth_date", nullable = false)
    private Date creationDate;

    @Column(nullable = false)
    private int experience;

    @Lob
    private byte[] image;

}

