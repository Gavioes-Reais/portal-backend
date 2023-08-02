package com.portal.estudante.controller;

import com.portal.estudante.entity.Achievement;
import com.portal.estudante.entity.AchievementStudent;
import com.portal.estudante.entity.Student;
import com.portal.estudante.service.AchievementService;
import com.portal.estudante.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/achievements")
public class AchievementController {

    AchievementService achievementService;
    StudentService studentService;

    @Autowired
    public AchievementController(AchievementService achievementService, StudentService studentService) {
        this.achievementService = achievementService;
        this.studentService = studentService;
    }

    @PostMapping("/{studentId}/add")
    public ResponseEntity<String> addAchievementToStudent(
            @PathVariable Long studentId,
            @RequestParam Long achievementId
    ) {
        Student student = studentService.findById(studentId);
        if (student == null) {
            return new ResponseEntity<>("Estudante não encontrado", HttpStatus.NOT_FOUND);
        }

        Achievement achievement = achievementService.findById(achievementId);
        if (achievement == null) {
            return new ResponseEntity<>("Conquista não encontrada", HttpStatus.NOT_FOUND);
        }

        AchievementStudent achievement_student = new AchievementStudent();
        achievement_student.setAcquisitionDate(new Date());
        achievement_student.setAchievement(achievement);
        achievement_student.setStudent(student);

        // Você pode adicionar mais lógica aqui, como verificar se o aluno já possui a conquista, etc.

        achievementService.addAchievementToStudent(achievement_student);
        return new ResponseEntity<>("Conquista adicionada com sucesso", HttpStatus.OK);
    }
}
