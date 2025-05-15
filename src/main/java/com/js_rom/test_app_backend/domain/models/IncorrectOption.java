package com.js_rom.test_app_backend.domain.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class IncorrectOption extends Option {

    public IncorrectOption() {
        super.setCorrect(false);
    }

    public IncorrectOption(String id, String description) {
        super(id, description);
        super.setCorrect(false);
    }

    @Override
    public void accept(OptionVisitor optionVisitor) {
        optionVisitor.visit(this);
    }
}
