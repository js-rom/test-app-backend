package com.js_rom.test_app_backend.infrastructure.postgres.entities;

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
}
