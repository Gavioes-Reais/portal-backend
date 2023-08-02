package com.portal.estudante.dto;

import java.util.Date;

public record AchievementDto(Long id, String name, String description,
                             Date creationDate, int experience, byte[] image) {

}
