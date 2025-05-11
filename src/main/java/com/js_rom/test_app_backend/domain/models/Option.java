package com.js_rom.test_app_backend.domain.models;

import lombok.EqualsAndHashCode;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class Option {

    @EqualsAndHashCode.Include
    private String id;
    private String description;
    private boolean isCorrect;

    Option(String description) {
        this.description = description;
    }

    Option(String id, String description) {
        this.id = id;
        this.description = description;
    }
}
