package com.js_rom.test_app_backend.infrastructure.postgres.entities;

import org.springframework.beans.BeanUtils;

import com.js_rom.test_app_backend.domain.models.CorrectOption;

import jakarta.persistence.Entity;

@Entity
public class CorrectOptionEntity extends OptionEntity {

    public CorrectOptionEntity() {
        super.setCorrect(true);
    }

    public CorrectOptionEntity(String description) {
        super(description);
        super.setCorrect(true);
    }

    public CorrectOptionEntity(String id, String description) {
        super(id, description);
        super.setCorrect(true);
    }

    public CorrectOptionEntity(CorrectOption correctOption) {
        BeanUtils.copyProperties(correctOption, this);
    }
}
