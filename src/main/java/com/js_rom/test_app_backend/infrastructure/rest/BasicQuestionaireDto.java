package com.js_rom.test_app_backend.infrastructure.rest;

import org.springframework.beans.BeanUtils;

import com.js_rom.test_app_backend.domain.models.Questionaire;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
public class BasicQuestionaireDto {

    private String id;
    private String description;

    public BasicQuestionaireDto(Questionaire questionaire) {
        this.id = questionaire.getId();
        this.description = questionaire.getDescription();
    }

}
