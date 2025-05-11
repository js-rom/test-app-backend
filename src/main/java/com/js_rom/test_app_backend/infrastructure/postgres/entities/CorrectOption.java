package com.js_rom.test_app_backend.infrastructure.postgres.entities;

import jakarta.persistence.Entity;

@Entity
public class CorrectOption extends Option {

    CorrectOption() {
        super.setCorrect(true);
    }

    CorrectOption(String description) {
        super(description);
        super.setCorrect(true);
    }

    CorrectOption(String id, String description) {
        super(id, description);
        super.setCorrect(true);
    }
}
