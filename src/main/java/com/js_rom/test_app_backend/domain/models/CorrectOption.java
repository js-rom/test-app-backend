package com.js_rom.test_app_backend.domain.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CorrectOption extends Option {

    private boolean isCorrect = true;

    CorrectOption(String id, String description) {
        super(id, description);
    }
}
