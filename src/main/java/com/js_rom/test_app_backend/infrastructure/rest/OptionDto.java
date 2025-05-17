package com.js_rom.test_app_backend.infrastructure.rest;

import org.springframework.beans.BeanUtils;

import com.js_rom.test_app_backend.domain.models.CorrectOption;
import com.js_rom.test_app_backend.domain.models.IncorrectOption;
import com.js_rom.test_app_backend.domain.models.Option;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class OptionDto {

    String id;
    String description;

    public OptionDto(Option option) {
        BeanUtils.copyProperties(option, this);
    }

    public Option toCorrectOption() {
        return new CorrectOption(id, description);
    }

    public Option toIncorrectOption() {
        return new IncorrectOption(id, description);
    }
}
