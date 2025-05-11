package com.js_rom.test_app_backend.infrastructure.postgres.entities;

import jakarta.persistence.Entity;

@Entity
public class IncorrectOption extends Option {

    IncorrectOption() {
        super.setCorrect(false);
    }

    IncorrectOption(String description) {
        super(description);
        super.setCorrect(true);
    }

    IncorrectOption(String id, String description) {
        super(id, description);
        super.setCorrect(true);
    }
}
