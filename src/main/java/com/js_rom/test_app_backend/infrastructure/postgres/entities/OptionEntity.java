package com.js_rom.test_app_backend.infrastructure.postgres.entities;

import java.util.UUID;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.js_rom.test_app_backend.domain.models.Option;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.EqualsAndHashCode;
import lombok.AllArgsConstructor;
import lombok.Data;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "type"
)
@JsonSubTypes({
    @JsonSubTypes.Type(value = CorrectOptionEntity.class, name = "correct"),
    @JsonSubTypes.Type(value = IncorrectOptionEntity.class, name = "incorrect")
})
@Data
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class OptionEntity {

    @EqualsAndHashCode.Include
    @Id
    private String id;
    private String description = "";
    private boolean isCorrect;

    OptionEntity() {
        this.id = UUID.randomUUID().toString();
    }

    OptionEntity(String description) {
        this();
        this.description = description;
    }

    OptionEntity(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public abstract Option toOption();

}
