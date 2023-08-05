package com.portal.estudante.service;

import com.portal.estudante.entity.Achievement;
import com.portal.estudante.entity.AchievementStudent;
import com.portal.estudante.repository.AchievementRepository;
import com.portal.estudante.repository.AchievementStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AchievementService {

    @Autowired
    AchievementRepository achievementRepository;

    @Autowired
    AchievementStudentRepository achievementStudentRepository;


    public Achievement findById(Long id) {
        Optional<Achievement> optionalAchievement = achievementRepository.findById(id);
        return optionalAchievement.orElse(null);
    }

    public List<Achievement> findAll() {
        return achievementRepository.findAll();
    }

    public void addAchievementToStudent(AchievementStudent achievementstudent) {
        // Adicione qualquer lógica adicional aqui, se necessário, antes de salvar a conquista do aluno
        achievementRepository.save(achievementstudent);
    }
}
