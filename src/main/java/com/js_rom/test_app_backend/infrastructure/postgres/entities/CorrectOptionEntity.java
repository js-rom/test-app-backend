package com.js_rom.test_app_backend.infrastructure.postgres.entities;

import jakarta.persistence.Entity;

@Entity
public class CorrectOptionEntity extends OptionEntity {

    CorrectOptionEntity() {
        super.setCorrect(true);
    }

    CorrectOptionEntity(String description) {
        super(description);
        super.setCorrect(true);
    }

    CorrectOptionEntity(String id, String description) {
        super(id, description);
        super.setCorrect(true);
    }
}
