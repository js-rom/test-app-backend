package com.js_rom.test_app_backend.domain.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Singular;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Questionaire {

    @EqualsAndHashCode.Include
    private String id;
    private String description;
    @Singular
    private List<SingleSelectionQuestion> singleSelectionQuestions;

}
