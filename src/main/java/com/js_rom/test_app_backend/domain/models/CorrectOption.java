package com.js_rom.test_app_backend.domain.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CorrectOption extends Option {

    public CorrectOption() {
        super.setCorrect(true);
    }

    public CorrectOption(String id, String description) {
        super(id, description);
        super.setCorrect(true);
    }
}
