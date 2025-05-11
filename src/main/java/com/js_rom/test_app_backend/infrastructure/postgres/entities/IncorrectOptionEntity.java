package com.js_rom.test_app_backend.infrastructure.postgres.entities;

import jakarta.persistence.Entity;

@Entity
public class IncorrectOptionEntity extends OptionEntity {

    public IncorrectOptionEntity() {
        super.setCorrect(false);
    }

    public IncorrectOptionEntity(String description) {
        super(description);
        super.setCorrect(true);
    }

    public IncorrectOptionEntity(String id, String description) {
        super(id, description);
        super.setCorrect(true);
    }
}
