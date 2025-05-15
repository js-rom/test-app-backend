package com.js_rom.test_app_backend.domain.models;

import lombok.EqualsAndHashCode;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.Data;
import lombok.NoArgsConstructor;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "type"
)
@JsonSubTypes({
    @JsonSubTypes.Type(value = CorrectOption.class, name = "correct"),
    @JsonSubTypes.Type(value = IncorrectOption.class, name = "incorrect")
})
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
