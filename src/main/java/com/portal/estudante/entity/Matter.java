package com.portal.estudante.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "matter")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Matter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false)
    public String name;

    @Column(nullable = false)
    public String series;

    @Column(nullable = false)
    public String img_url;

    @ManyToOne
    @JoinColumn(name = "idTeacher")
    private Teacher teacher;
}
