package com.js_rom.test_app_backend.infrastructure.postgres.entities;

import org.springframework.beans.BeanUtils;

import com.js_rom.test_app_backend.domain.models.IncorrectOption;

import jakarta.persistence.Entity;

@Entity
public class IncorrectOptionEntity extends OptionEntity {

    public IncorrectOptionEntity() {
        super.setCorrect(false);
    }

    public IncorrectOptionEntity(String description) {
        super(description);
        super.setCorrect(false);
    }

    public IncorrectOptionEntity(String id, String description) {
        super(id, description);
        super.setCorrect(false);
    }

    public IncorrectOptionEntity(IncorrectOption incorrectOption) {
        BeanUtils.copyProperties(incorrectOption, this);
    }
}
