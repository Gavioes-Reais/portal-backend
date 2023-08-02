package com.portal.estudante.repository;

import com.portal.estudante.entity.AchievementStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AchievementStudentRepository extends JpaRepository<AchievementStudent, Long> {

}
