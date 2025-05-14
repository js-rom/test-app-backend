package com.js_rom.test_app_backend.infrastructure.postgres.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Singular;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Builder
public class SingleSelectionQuestionEntity {

    @EqualsAndHashCode.Include
    @Id
    private String id;
    private String description;
    @Singular
    @OneToMany(cascade = CascadeType.ALL)
    private List<OptionEntity> options;
}
