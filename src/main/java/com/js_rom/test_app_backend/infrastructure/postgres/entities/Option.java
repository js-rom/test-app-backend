package com.js_rom.test_app_backend.infrastructure.postgres.entities;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.EqualsAndHashCode;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Option {

    @EqualsAndHashCode.Include
    @Id
    private String id;
    private String description = "";
    private boolean isCorrect;

    Option() {
        this.id = UUID.randomUUID().toString();
    }

    Option(String description) {
        this();
        this.description = description;
    }

    Option(String id, String description) {
        this.id = id;
        this.description = description;
    }
}
