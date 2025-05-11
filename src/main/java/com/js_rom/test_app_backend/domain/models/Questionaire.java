package com.js_rom.test_app_backend.domain.models;

import java.util.List;

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
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Questionaire {

    @EqualsAndHashCode.Include
    private String id;
    private String description;
    @Singular
    private List<SingleSelectionQuestion> singleSelectionQuestions;

}
