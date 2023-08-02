package com.portal.estudante.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity(name = "achievementstudent")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AchievementStudent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Date acquisitionDate;

    @OneToOne
    @JoinColumn(name = "id_achievement")
    private Achievement achievement;

    @OneToOne
    @JoinColumn(name = "id_student")
    private Student student;

}
